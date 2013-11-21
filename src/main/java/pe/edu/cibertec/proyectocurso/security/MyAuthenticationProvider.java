/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.proyectocurso.model.Rol;
import pe.edu.cibertec.proyectocurso.model.Usuario;
import pe.edu.cibertec.proyectocurso.service.UsuarioService;

/**
 *
 * @author JAVA-ADV-VS
 */
@Component("myAuthenticationProvider")
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsuarioService servicioUsuario;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Usuario objUsuario = new Usuario();
        objUsuario.setNombre(name);
        objUsuario = servicioUsuario.obtenerUsuario(objUsuario);

        if (objUsuario != null) {
            if (name.equals(objUsuario.getNombre()) && password.equals(objUsuario.getClave())) {
                List<GrantedAuthority> grantedAuths = new ArrayList();
                //grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                List<Rol> lsrRoles = objUsuario.getLstRol();

                for (Rol r : lsrRoles) {
                    grantedAuths.add(new SimpleGrantedAuthority(r.getNombre()));
                }

                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
                return auth;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public UsuarioService getServicioUsuario() {
        return servicioUsuario;
    }

    public void setServicioUsuario(UsuarioService servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }
}
