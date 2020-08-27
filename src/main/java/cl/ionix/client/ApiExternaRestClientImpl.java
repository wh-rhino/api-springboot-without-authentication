package cl.ionix.client;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import cl.ionix.dto.ConsultaDTO;
import cl.ionix.dto.ItemDTO;
import cl.ionix.properties.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiExternaRestClientImpl implements ApiExternaRestClient {

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private PropertiesUtil.Uri uri;

	private static final Integer HTTP_STATUS_OK = 200;

	/**
	 * Metodo para invocar a url de sandbox.
	 * 
	 * @param rutUsuario
	 * @return
	 */
	@Override
	public ConsultaDTO consultarSandbox(String rutUsuario) {
		ConsultaDTO consulta = ConsultaDTO.builder().build();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ConsultaDTO> entity = new HttpEntity<>(null, headers);
		// TODO: Revisar dado que el metodo de cifrado esta generando error
		// ResponseEntity<ConsultaDTO> response = this.restTemplate.exchange(uri.getSandbox().concat(TransformacionUtil.cifradoDES(rutUsuario)), HttpMethod.GET, entity, ConsultaDTO.class);
		
		ResponseEntity<ConsultaDTO> response = this.restTemplate.exchange(uri.getSandbox().concat(rutUsuario), HttpMethod.GET, entity, ConsultaDTO.class);

		log.info("response : " + response.getBody().getDescription());

		if(response.getStatusCodeValue()==HTTP_STATUS_OK) {
			consulta = crearConsultaDTO(response.getBody());	
		}
		return consulta;	
	}

	private ConsultaDTO crearConsultaDTO(ConsultaDTO consultaDTO) {
		return ConsultaDTO.builder()
				.responseCode(consultaDTO.getResponseCode())
				.description(consultaDTO.getDescription())
				.result(crearItemDTO(consultaDTO))
				.build();
	}

	private ItemDTO crearItemDTO(ConsultaDTO consultaDTO) {
		return ItemDTO.builder()
				.items(consultaDTO.getResult().getItems())
				.registerCount(String.valueOf(consultaDTO.getResult().getItems().stream().count()))
				.build();
	}
}
