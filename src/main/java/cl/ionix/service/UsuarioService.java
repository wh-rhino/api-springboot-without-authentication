package cl.ionix.service;

import java.util.List;

import cl.ionix.dto.ConsultaDTO;
import cl.ionix.dto.ResponseDTO;
import cl.ionix.dto.UsuarioDTO;
import cl.ionix.model.UsuarioModel;

public interface UsuarioService {

	/**
	 * Metodo encargado de crear usuarios.
	 * 
	 * @param usuarioDTO
	 * @return ResponseDTO
	 */
	ResponseDTO crearUsuario(UsuarioDTO usuarioDTO);

	/**
	 * Metodo encargado de obtener todos los usuarios registrados.
	 * 
	 * @return
	 */
	List<UsuarioModel> obtenerUsuarios();

	/**
	 * Metodo encargado de obtener todos los usuarios registrados.
	 * 
	 * @return
	 */
	List<UsuarioModel> obtenerUsuarioByEmail(String email);

	/**
	 * Metodo encargado de ejecutar url sandbox.
	 * 
	 * @param usuarioDTO
	 * @return ConsultaDTO
	 */
	ConsultaDTO consultaSandBox(UsuarioDTO usuarioDTO);
	
}
