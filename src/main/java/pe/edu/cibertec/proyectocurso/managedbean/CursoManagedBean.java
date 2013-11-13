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
    
    private Curso objCurso= new Curso();
    
    private Integer codigoCurso;
    
    public CursoManagedBean() {
        
    }
    
    
    public String listarCursos(){
        listaCursos=servicioCurso.listarCursos();
        
        return "/curso/listaCursos?faces-redirect=true";
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

    public Curso getObjCurso() {
        return objCurso;
    }

    public void setObjCurso(Curso objCurso) {
        this.objCurso = objCurso;
    }
    
    public String grabarCurso(){
        if(objCurso.getCodigoCurso()==-1){
             System.out.print("ENTRA A INSERTAR CURSOS");
             servicioCurso.grabarCurso(objCurso);
        }else{
             System.out.print("ENTRA A ACTUALIZAR CURSOS");
             servicioCurso.actualizarCurso(objCurso);
        }
       
        
        return listarCursos();
    }
    
    public String nuevoCurso(){
        objCurso = new Curso();
        
        return "/curso/registroCursos";
    }
    
    public String obtenerCurso(){
        Curso curso= new Curso();
        curso.setCodigoCurso(codigoCurso);
        objCurso=servicioCurso.obtenerCurso(curso);
        return "/curso/registroCursos?faces-redirect=true";
    }
    
    public String eliminarCurso(){
        Curso curso= new Curso();
        curso.setCodigoCurso(codigoCurso);
        objCurso=servicioCurso.obtenerCurso(curso);         
        servicioCurso.eliminarCurso(objCurso);
        //return "/curso/listaCursos?faces-redirect=true";
        return listarCursos();
        
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    
    
    
}
