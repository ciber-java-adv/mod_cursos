
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
    private String descripcionCurso;

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

    @Override
    public String toString() {
        return "Curso{" + "codigoCurso=" + codigoCurso + ", descripcionCurso=" + descripcionCurso + '}';
    }
    
    
    
}
