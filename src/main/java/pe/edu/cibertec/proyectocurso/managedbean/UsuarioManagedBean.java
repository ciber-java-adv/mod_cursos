package pe.edu.cibertec.proyectocurso.managedbean;




import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.proyectocurso.model.Usuario;
import pe.edu.cibertec.proyectocurso.service.UsuarioService;

@Component
@Scope("session")
public class UsuarioManagedBean implements Serializable{

    private String v_codusu;
    private String v_passusu;
    
    
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;
    
    
    @Autowired    
    private UsuarioService servicioUsuario;
    
    public UsuarioManagedBean() {
    }

    public String ejecutarLogin() throws ServletException, IOException{
        String vista = null;
        
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(
                    v_codusu, v_passusu);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            vista = "/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            vista = "/login";
        }
        
        
        /*
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
 
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                 .getRequestDispatcher("/j_spring_security_check");
 
        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
 
        FacesContext.getCurrentInstance().responseComplete();
        */
        return vista;

    }

    public String getV_codusu() {
        return v_codusu;
    }

    public void setV_codusu(String v_codusu) {
        this.v_codusu = v_codusu;
    }

    public String getV_passusu() {
        return v_passusu;
    }

    public void setV_passusu(String v_passusu) {
        this.v_passusu = v_passusu;
    }
    
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    

    public UsuarioService getServicioUsuario() {
        return servicioUsuario;
    }

    public void setServicioUsuario(UsuarioService servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }
    
    
    
    
}
