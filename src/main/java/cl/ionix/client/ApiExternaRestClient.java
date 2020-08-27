package cl.ionix.client;

import cl.ionix.dto.ConsultaDTO;

public interface ApiExternaRestClient {

	/**
	 * Metodo para invocar a url de sandbox.
	 * 
	 * @param rutUsuario
	 * @return ConsultaDTO
	 */
	ConsultaDTO consultarSandbox(String rutUsuario);
	
}
