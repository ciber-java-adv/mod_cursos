/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectocurso.model.Auditoria;

/**
 *
 * @author LUIS BENVENUTO
 */
@Service("auditoriaService")
public interface AuditoriaService {
    
    
    
    public void insertarAuditoria(Auditoria objAuditoria);
        
    
    
    
}
