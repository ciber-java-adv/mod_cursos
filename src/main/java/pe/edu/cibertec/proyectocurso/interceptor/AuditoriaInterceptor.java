/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.interceptor;

import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.proyectocurso.model.Auditoria;
import pe.edu.cibertec.proyectocurso.model.Curso;
import pe.edu.cibertec.proyectocurso.service.AuditoriaService;

/**
 *
 * @author LUIS BENVENUTO
 */

@Aspect
@Component("auditoriaInterceptor")
public class AuditoriaInterceptor {
    
    @Autowired
    private AuditoriaService servicioAuditoria;
    
  
    public void antesEliminarCursoInterceptor(JoinPoint joinPoint) {
        Curso objCurso = (Curso)joinPoint.getArgs()[0];
        Auditoria objAuditoria= new Auditoria();
        objAuditoria.setFecha(new Date());
        objAuditoria.setValor(objCurso.toString());
        servicioAuditoria.insertarAuditoria(objAuditoria);
    }

    public AuditoriaService getServicioAuditoria() {
        return servicioAuditoria;
    }

    public void setServicioAuditoria(AuditoriaService servicioAuditoria) {
        this.servicioAuditoria = servicioAuditoria;
    }
    
    
    
    
    
    
}
