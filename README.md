Spring boot RESTful API
1.0. Generación imagen Docker
docker build -t nombre-image .

2.0. Ejecución
2.1.0. Contenedor
Especifica la forma en que se ejecuta la aplicación en un contenedor docker:

docker run -d -p 8000:8000 nombre-image

3.0. Script SQL (Ejecutar en local sobre motor PostgreSQL)

-- Drop table

-- DROP TABLE public.usuarios

CREATE TABLE public.usuarios (
	id_usuario serial NOT NULL,
	nombre varchar(12) NOT NULL,
	nombre_usuario varchar(12) NOT NULL,
	email varchar(24) NOT NULL,
	telefono varchar(12) NOT NULL,
	fecha timestamp NOT NULL,
	CONSTRAINT usuarios_pk PRIMARY KEY (email),
	CONSTRAINT usuarios_usuarios_fk FOREIGN KEY (email) REFERENCES usuarios(email)
);

-- Permissions

ALTER TABLE public.usuarios OWNER TO postgres;
GRANT ALL ON TABLE public.usuarios TO postgres;

4.0. Ejecución via gradle (Gradle 6.3)
4.1.0 gradle bootRun 

5.0. Invocación endpoints via CURLs
5.1.0 Crear usuarios (Considerar que el email del usuario no se puede repetir):

curl --location --request POST 'http://localhost:8080/usuario' \
--header 'Content-Type: application/json' \
--data-raw '{
    "usuario":"1-9",
    "nombreUsuario":"Homero",
    "email":"nuevo@gmail.com",
    "telefono":"82725349"
}
'

5.2.0 Listar usuarios:

curl --location --request GET 'http://localhost:8080/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
    "usuario":"usuario",
    "nombreUsuario":"nombreUsuario",
    "email":"email",
    "telefono":"12345678"
}
'

5.3.0 Listar usuarios por email:

curl --location --request GET 'http://localhost:8080/usuario/homero@gmail.com' \
--header 'Content-Type: application/json' \
--data-raw '{
    "usuario":"usuario",
    "nombreUsuario":"nombreUsuario",
    "email":"email",
    "telefono":"12345678"
}
'

5.4.0 Consulta sandbox:

curl --location --request POST 'http://localhost:8080/consultar' \
--header 'Content-Type: application/json' \
--data-raw '{
    "usuario":"1-9"
}
'

7. Change Log
Versión Version release (Fecha Release)
Detallar cambios realizados en release
Version mas reciente debe ir primero
Versión 1.0.0 (26/08/2020)
Generación proyecto de ejemplo
