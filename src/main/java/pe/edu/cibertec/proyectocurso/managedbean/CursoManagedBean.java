/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.proyectocurso.model.Curso;
import pe.edu.cibertec.proyectocurso.service.CursoService;

/**
 *
 * @author LUIS BENVENUTO
 */

@Component
@Scope("session")
public class CursoManagedBean implements Serializable{
    

    /**
     * Creates a new instance of CursoManagedBean
     */
    
    //@ManagedProperty(value="#{cursoService}")
    @Autowired
    private CursoService servicioCurso;
    private List<Curso> listaCursos= new ArrayList<Curso>();
    
    public CursoManagedBean() {
        
    }
    
    
    public String listarCursos(){
        listaCursos=servicioCurso.listarCursos();
        
        return "curso/listaCursos";
    }

    public CursoService getServicioCurso() {
        return servicioCurso;
    }

    public void setServicioCurso(CursoService servicioCurso) {
        this.servicioCurso = servicioCurso;
    }

   
    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    
    
}
