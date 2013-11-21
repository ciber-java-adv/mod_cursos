/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author JAVA-ADV-VS
 */
@Entity
@Table(name="rol")
public class Rol {
    
    @Id
    @Column(name="idrol")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idrol;
    
    @Column(name="nombre")
    private String nombre;
    
    @ManyToMany(mappedBy="lstRol")
    private List<Usuario> lstUsuarios;

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    
    
}
