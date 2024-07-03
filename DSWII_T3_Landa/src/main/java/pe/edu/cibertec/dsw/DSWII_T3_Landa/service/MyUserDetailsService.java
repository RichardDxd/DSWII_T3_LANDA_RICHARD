package pe.edu.cibertec.dsw.DSWII_T3_Landa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.model.Usuario;
import pe.edu.cibertec.dsw.DSWII_T3_Landa.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getNomusuario())
                .password(usuario.getPassword())
                .roles(usuario.getRoles().stream().map(r -> r.getNomrol()).toArray(String[]::new))
                .build();
    }
}
