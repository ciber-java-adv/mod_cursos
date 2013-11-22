/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectocurso.dao.UsuarioDao;
import pe.edu.cibertec.proyectocurso.model.Usuario;

/**
 *
 * @author francisco
 */
@Repository("usuarioDaoImpl")
public class UsuarioDaoImpl implements UsuarioDao {

    @Autowired
    private SessionFactory sessionFactory;
    
   
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Usuario obtenerUsuario(Usuario objUsuario) {
        Usuario usuario = null;
        Query q=sessionFactory.getCurrentSession().createQuery("select u from Usuario u join fetch u.lstRol where u.nombre=:nombre");
        q.setParameter("nombre", objUsuario.getNombre());
        usuario=(Usuario) q.uniqueResult();
        return usuario;
    }
}
