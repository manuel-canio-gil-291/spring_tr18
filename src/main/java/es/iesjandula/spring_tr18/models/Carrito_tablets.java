package es.iesjandula.spring_tr18.models;

public class Carrito_tablets 
{
    private Integer id;
    private Integer numero_tablets, planta;

    public Carrito_tablets()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_tablets() {
        return numero_tablets;
    }

    public void setNumero_tablets(Integer numero_tablets) {
        this.numero_tablets = numero_tablets;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    
}
