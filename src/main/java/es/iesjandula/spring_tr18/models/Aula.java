package es.iesjandula.spring_tr18.models;

public class Aula 
{
    private Integer id;
    private Integer numero_aula, planta;
    
    public Aula()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_aula() {
        return numero_aula;
    }

    public void setNumero_aula(Integer numero_aula) {
        this.numero_aula = numero_aula;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    
}
