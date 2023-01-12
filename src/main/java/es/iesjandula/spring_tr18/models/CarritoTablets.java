package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_tablets")
public class CarritoTablets 
{
    @Id
    @Column(length = 10)
    private Integer id;
    @Column(length = 3)
    private Integer numeroTablets;
    @Column(length = 1, nullable = false)
    private Integer planta;

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
