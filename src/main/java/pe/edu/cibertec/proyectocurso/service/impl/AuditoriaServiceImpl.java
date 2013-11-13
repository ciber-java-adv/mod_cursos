/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.proyectocurso.dao.AuditoriaDao;
import pe.edu.cibertec.proyectocurso.model.Auditoria;
import pe.edu.cibertec.proyectocurso.service.AuditoriaService;

/**
 *
 * @author LUIS BENVENUTO
 */
@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService{
    
    @Autowired
    private AuditoriaDao daoAuditoria;
    
    @Transactional
    @Override
    public void insertarAuditoria(Auditoria objAuditoria) {
        
         daoAuditoria.insertarAuditoria(objAuditoria);
        
    }

    public AuditoriaDao getDaoAuditoria() {
        return daoAuditoria;
    }

    public void setDaoAuditoria(AuditoriaDao daoAuditoria) {
        this.daoAuditoria = daoAuditoria;
    }
}
