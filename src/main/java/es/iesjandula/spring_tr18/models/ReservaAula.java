package es.iesjandula.spring_tr18.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas_aulas")
public class ReservaAula 
{   
    //@JoinColumn(name = "id_profesor")
    //@MapsId("idProfesor")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor idProfesor;
    //@JoinColumn(name = "id_aula")
    //@MapsId("idAula")
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AulaInformatica idAula;
    //@MapsId("fecha")
    @Id
    @Column(name = "fecha", nullable = false)
    private String fecha;

    public ReservaAula()
    {

    }

    public ReservaAula(Profesor idProfesor, AulaInformatica idAula, String fecha) {
        this.idProfesor = idProfesor;
        this.idAula = idAula;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}
