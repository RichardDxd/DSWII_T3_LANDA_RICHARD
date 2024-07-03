package pe.edu.cibertec.dsw.DSWII_T3_Landa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

}
