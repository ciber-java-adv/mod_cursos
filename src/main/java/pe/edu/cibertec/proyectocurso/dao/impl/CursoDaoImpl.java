
package pe.edu.cibertec.proyectocurso.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyectocurso.dao.CursoDao;
import pe.edu.cibertec.proyectocurso.model.Curso;

@Repository("cursoDaoImpl")
public class CursoDaoImpl  implements CursoDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Curso> listarCursos() {
        
        List<Curso> listaCurso=sessionFactory.getCurrentSession().createQuery("from Curso").list();
        
        return listaCurso;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
        
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void grabarCurso(Curso objCurso) {
       sessionFactory.getCurrentSession().save(objCurso);
    }
    
    
    
}
