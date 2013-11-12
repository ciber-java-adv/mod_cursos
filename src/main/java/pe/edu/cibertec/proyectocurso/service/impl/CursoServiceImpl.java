
package pe.edu.cibertec.proyectocurso.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.proyectocurso.dao.CursoDao;
import pe.edu.cibertec.proyectocurso.model.Curso;
import pe.edu.cibertec.proyectocurso.service.CursoService;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements CursoService{
    
    @Autowired
    private CursoDao cursoDao;

    public CursoDao getCursoDao() {
        return cursoDao;
    }
           
    
    public void setCursoDao(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Curso> listarCursos() {
        return cursoDao.listarCursos();
    }
    
    
    
    
}