package es.iesjandula.spring_tr18.models;

import java.util.Date;

public class ReservaAula 
{
    private Profesor idProfesor;
    private AulaInformatica idAula;
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
