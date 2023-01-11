package es.iesjandula.spring_tr18.models;

import java.util.Date;

public class Reserva_aula 
{
    private Profesor id_profesor;
    private Aula id_aula;
    private Date fecha;

    public Reserva_aula()
    {

    }

    public Profesor getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Profesor id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Aula getId_aula() {
        return id_aula;
    }

    public void setId_aula(Aula id_aula) {
        this.id_aula = id_aula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
