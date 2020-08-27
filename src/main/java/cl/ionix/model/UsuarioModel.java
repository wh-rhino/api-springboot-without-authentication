package cl.ionix.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario"}))
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 3280620176790738528L;

	@Id
	@SequenceGenerator(name = "usuarios_id_usuario_seq", sequenceName = "usuarios_id_usuario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_usuario_seq")
	@Column(name = "id_usuario", unique = true, updatable = false, nullable = false, precision = 12, scale = 0)
	private Integer idUsuario;
	
	@Column(name = "nombre", length = 12, updatable = false, nullable = false)
	private String nombre;
	
	@Column(name = "nombre_usuario", length = 12, updatable = false, nullable = false)
	private String nombreUsuario;
	
	@Column(name = "telefono", length = 12, updatable = false, nullable = false)
	private String telefono;
	
	@Column(name = "email", length = 24, updatable = false, nullable = false)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false)
	private Date fecha;
}
