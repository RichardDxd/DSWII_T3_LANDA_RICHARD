package pe.edu.cibertec.dsw.DSWII_T3_Landa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
