package pe.edu.cibertec.proyectocurso.service;

import java.util.List;
import pe.edu.cibertec.proyectocurso.model.Curso;

public interface CursoService {

    public List<Curso> listarCursos();

    public void grabarCurso(Curso objCurso);

    public Curso obtenerCurso(Curso objCurso);

    public void actualizarCurso(Curso objCurso);

    public void eliminarCurso(Curso objCurso);
}
