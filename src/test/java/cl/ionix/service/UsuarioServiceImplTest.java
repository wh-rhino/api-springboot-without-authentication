package cl.ionix.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootConfiguration
@ContextConfiguration
@SpringBootTest
public class UsuarioServiceImplTest {

	@InjectMocks
	private UsuarioServiceImpl service;
	
	@Test
	void contextLoads() {
	}

}
