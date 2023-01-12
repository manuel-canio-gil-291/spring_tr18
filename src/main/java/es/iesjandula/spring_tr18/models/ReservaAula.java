package es.iesjandula.spring_tr18.models;

import java.util.Date;

//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.MapsId;
//import jakarta.persistence.Table;

//@Entity
//@Table(name = "reserva_aula")
public class ReservaAula 
{
    //@EmbeddedId
    private ReservaAulaId reservaAulaId;
    //@ManyToOne
    //@JoinColumn(name = "id_profesor")
    //@MapsId("idProfesor")
    private Profesor idProfesor;
    //@ManyToOne
    //@JoinColumn(name = "id_aula")
    //@MapsId("idAula")
    private AulaInformatica idAula;
    //@MapsId("fecha")
    private Date fecha;

    public ReservaAula()
    {

    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor id_profesor) {
        this.idProfesor = id_profesor;
    }

    public AulaInformatica getIdAula() {
        return idAula;
    }

    public void setIdAula(AulaInformatica id_aula) {
        this.idAula = id_aula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
