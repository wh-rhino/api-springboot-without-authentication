package cl.ionix.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.ionix.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>, UsuarioRepositoryExtension {
	List<UsuarioModel> findByEmail(String email);
}
