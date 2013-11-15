
package pe.edu.cibertec.proyectocurso.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable{
    
    @Id
    @Column(name="idcurso")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer codigoCurso;
    
    @Column(name="nombrecurso")
    private String nombreCurso;
    
    @Column(name = "descripcioncurso")
    private String descripcionCurso;
    
    @Column(name = "tipocurso")
    private String tipoCurso;
    
    @Column(name = "modalidadpago")
    private String modalidadPago;
    
    @Column(name = "duracion")
    private String duracion;

    
    public Curso() {
        codigoCurso=-1;
    }

                  
    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getModalidadPago() {
        return modalidadPago;
    }

    public void setModalidadPago(String modalidadPago) {
        this.modalidadPago = modalidadPago;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    
    @Override
    public String toString() {
        return "Curso{" + "codigoCurso=" + codigoCurso + ", descripcionCurso=" + descripcionCurso + '}';
    }
    
    
    
}
