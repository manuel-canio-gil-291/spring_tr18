package es.iesjandula.spring_tr18.models;

public class CarritoTablets 
{
    private Integer id;
    private Integer numeroTablets, planta;

    public CarritoTablets()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroTablets() {
        return numeroTablets;
    }

    public void setNumeroTablets(Integer numero_tablets) {
        this.numeroTablets = numero_tablets;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    
}
