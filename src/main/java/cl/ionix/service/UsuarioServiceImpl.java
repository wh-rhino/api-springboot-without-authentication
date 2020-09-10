package cl.ionix.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.ionix.client.ApiExternaRestClient;
import cl.ionix.dto.ConsultaDTO;
import cl.ionix.dto.ResponseDTO;
import cl.ionix.dto.UsuarioDTO;
import cl.ionix.model.UsuarioModel;
import cl.ionix.properties.PropertiesUtil;
import cl.ionix.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PropertiesUtil.Errores error;

	@Autowired
	private ApiExternaRestClient apiExternaRestClient;

	/**
	 * Metodo encargado de crear usuarios.
	 * 
	 * @param usuarioDTO
	 * @return ResponseDTO
	 */
	@Override
	public ResponseDTO crearUsuario(UsuarioDTO usuarioDTO) {
		ResponseDTO response = null;
		try {
			UsuarioModel userModel = repository.save(crearUsuarioModel(usuarioDTO));
			response = crearResponseDTO(userModel.getIdUsuario(), error.getCrearusuario().getExito().getCodigo(), error.getCrearusuario().getExito().getDescription());
		} catch (Exception e) {
			log.error("crearUsuario Exception : ", e.getCause());
			response = crearResponseDTO(null, error.getCrearusuario().getFracaso().getCodigo(), error.getCrearusuario().getFracaso().getDescription());
		}
		return response;
	}

	private ResponseDTO crearResponseDTO(Integer identificador, String codigo, String description) {
		return ResponseDTO.builder().id(identificador).codigo(codigo).descripcion(description).build();
	}

	private UsuarioModel crearUsuarioModel(UsuarioDTO usuarioDTO) {
		return UsuarioModel.builder()
				.nombre(usuarioDTO.getUsuario())
				.nombreUsuario(usuarioDTO.getNombreUsuario())
				.email(usuarioDTO.getEmail())
				.telefono(usuarioDTO.getTelefono())
				.fecha(new Date())
				.build();
	}

	/**
	 * Metodo encargado de obtener todos los usuarios registrados.
	 * 
	 * @return List<UsuarioModel>
	 */
	@Override
	public List<UsuarioModel> obtenerUsuarios() {
		List<UsuarioModel> listaUsuarios = null;
		try {
			listaUsuarios = repository.findAll();
		} catch (Exception e) {
			log.error("obtenerUsuarios Exception : ", e.getCause());
		}
		return listaUsuarios;
	}

	/**
	 * Metodo encargado de obtener un usuario en base a su email.
	 * 
	 * @return List<UsuarioModel>
	 */
	@Override
	public List<UsuarioModel> obtenerUsuarioByEmail(String email) {
		List<UsuarioModel> listaUsuarios = null;
		try {
			listaUsuarios = repository.findByEmail(email);
		} catch (Exception e) {
			log.error("obtenerUsuarioByEmail Exception : ", e.getCause());
		}
		return listaUsuarios;
	}

	/**
	 * Metodo encargado de ejecutar url sandbox.
	 * 
	 * @param usuarioDTO
	 * @return ConsultaDTO
	 */
	@Override
	public ConsultaDTO consultaSandBox(UsuarioDTO usuarioDTO) {
		Instant start = Instant.now();
		ConsultaDTO consulta = null;
		try {
			consulta = apiExternaRestClient.consultarSandbox(usuarioDTO.getUsuario());
		} catch (Exception e) {
			log.error("consultaSandBox Exception : ", e.toString());
		}	
		Instant end = Instant.now();
		if(consulta != null) {
			consulta.setElapsedTime(Duration.between(start, end).toMillis());
		}
		return consulta;
	}

}
