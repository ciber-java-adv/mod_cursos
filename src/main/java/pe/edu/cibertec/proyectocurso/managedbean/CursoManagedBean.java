/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.proyectocurso.model.Curso;
import pe.edu.cibertec.proyectocurso.service.CursoService;
import pe.edu.cibertec.proyectocurso.util.Constante;

/**
 *
 * @author LUIS BENVENUTO
 */

@Component
@Scope("session")
public class CursoManagedBean implements Serializable{
    private static Logger logger = Logger.getLogger(CursoManagedBean.class);
    
    //@ManagedProperty(value="#{cursoService}")
    @Autowired
    private CursoService servicioCurso;
    private List<Curso> listaCursos= new ArrayList<Curso>();
    
    private Curso objCurso= new Curso();    
    private Integer codigoCurso;
    private List<SelectItem> listTipoCurso;
    
    public CursoManagedBean() {        
        logger.info("Inicio - CursoManagedBean");
        cargar();
        logger.debug("Fin - CursoManagedBean");
    }
    
    
    public String listarCursos(){
        logger.info("Listar Cursos");
        listaCursos=servicioCurso.listarCursos();
        
        return "/curso/listaCursos?faces-redirect=true";
    }
        
    public String grabarCurso(){
        if(objCurso.getCodigoCurso()==-1){
             logger.info("ENTRA A INSERTAR CURSOS");
             servicioCurso.grabarCurso(objCurso);
        }else{
             logger.info("ENTRA A ACTUALIZAR CURSOS");
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
    
    //Otros Metodos
    private void cargar(){
        listTipoCurso = new ArrayList<SelectItem>();
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_CIENCIAS, Constante.TIPOCURSO_CIENCIAS_DESC));
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_HUMANIDADES, Constante.TIPOCURSO_HUMANIDADES_DESC));
        listTipoCurso.add(new SelectItem(Constante.TIPOCURSO_POLITICA, Constante.TIPOCURSO_POLITICA_DESC));
    }
    
    
    //Metodos Get - Set
    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
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

    public List<SelectItem> getListTipoCurso() {
        return listTipoCurso;
    }
    
}
