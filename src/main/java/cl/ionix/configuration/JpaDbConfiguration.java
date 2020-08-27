package cl.ionix.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import cl.ionix.model.UsuarioModel;
import cl.ionix.repository.UsuarioRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
@EntityScan(basePackageClasses = UsuarioModel.class)
public class JpaDbConfiguration {

}
