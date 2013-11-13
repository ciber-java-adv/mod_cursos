/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectocurso.dao.AuditoriaDao;
import pe.edu.cibertec.proyectocurso.model.Auditoria;

/**
 *
 * @author LUIS BENVENUTO
 */
@Repository("auditoriaDaoImpl")
public class AuditoriaDaoImpl implements AuditoriaDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void insertarAuditoria(Auditoria objAuditoria) {
       sessionFactory.getCurrentSession().save(objAuditoria);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
}
