package cl.ionix.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cl.ionix.dto.ConsultaDTO;
import cl.ionix.dto.ResponseDTO;
import cl.ionix.dto.UsuarioDTO;
import cl.ionix.model.UsuarioModel;
import cl.ionix.service.UsuarioServiceImpl;
import io.swagger.annotations.ApiOperation;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;
	
	@ApiOperation("Endpoint que permite crear usuarios")
	@PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return service.crearUsuario(usuarioDTO);
	}
	
	@ApiOperation("Endpoint que permite listar usuarios registrados")
	@GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioModel> obtenerUsuarios() {
		return service.obtenerUsuarios();
	}
	
	@ApiOperation("Endpoint que permite obtener un usuario en base a su email")
	@GetMapping(value = "/usuario/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioModel> obtenerUsuario(@PathVariable("email") String email) {
		return service.obtenerUsuarioByEmail(email);
	}

	@ApiOperation("Endpoint que permite consultar api externa")
	@PostMapping(value = "/consultar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsultaDTO consultarApi(@RequestBody UsuarioDTO usuarioDTO) {
		return service.consultaSandBox(usuarioDTO);
	}
}
