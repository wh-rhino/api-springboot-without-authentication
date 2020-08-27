package cl.ionix.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class PropertiesUtil {

	PropertiesUtil(){
	}
	
	@Bean
	@ConfigurationProperties(prefix = "errores")
	public Errores errores() {
		return new Errores();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "uri")
	public Uri uri() {
		return new Uri();
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Errores {
		private CrearUsuario crearusuario;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class CrearUsuario {
		private DescriptionError exito;
		private DescriptionError fracaso;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class DescriptionError {
		private String codigo;
		private String description;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Uri {
		private String sandbox;
	}
}
