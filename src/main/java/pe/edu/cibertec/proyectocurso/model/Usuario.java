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
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "clave")
    private String clave;
    
    @ManyToMany
    @JoinTable(name = "usuario_rol",
    joinColumns = {
        @JoinColumn(name = "idusuario")},
    inverseJoinColumns = {
        @JoinColumn(name = "idrol")})
    private List<Rol> lstRol;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public List<Rol> getLstRol() {
        return lstRol;
    }

    public void setLstRol(List<Rol> lstRol) {
        this.lstRol = lstRol;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
