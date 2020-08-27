package cl.ionix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {
	private Integer responseCode;
	private String description;
	private long elapsedTime;
	private ItemDTO result;
}
