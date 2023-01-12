package es.iesjandula.spring_tr18.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;

@Embeddable
public class ReservaAulaId implements Serializable
{
    private static final long serialVersionUID = -371230006210513L;

    private Long idProfesor;
    private Long idAula;
    private Date fecha;

    public ReservaAulaId()
    {

    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
