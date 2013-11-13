/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.proyectocurso.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author LUIS BENVENUTO
 */
@Entity
@Table(name="auditoria")
public class Auditoria implements Serializable{
    
    @Id
    @Column(name="idauditoria")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idauditoria;
    
    @Column(name="fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @Column(name="valor")
    private String valor;
    
    

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "idauditoria=" + idauditoria + ", fecha=" + fecha + ", valor=" + valor + '}';
    }
    
    
    
}
