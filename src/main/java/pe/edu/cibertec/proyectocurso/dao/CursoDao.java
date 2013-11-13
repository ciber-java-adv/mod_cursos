
package pe.edu.cibertec.proyectocurso.dao;

import java.util.List;
import pe.edu.cibertec.proyectocurso.model.Curso;


public interface CursoDao {
    
    public List<Curso> listarCursos();
    public Curso obtenerCurso(Curso objCurso);
    public void grabarCurso(Curso objCurso);
    public void actualizarCurso(Curso objCurso);
    public void eliminarCurso(Curso objCurso);
    
}
