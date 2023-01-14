package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritos_tablets")
public class CarritoTablets 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3)
    private Integer numeroTablets;
    @Column(length = 1, nullable = false)
    private Integer planta;

    public CarritoTablets()
    {

    }

    public CarritoTablets(Long id, Integer numeroTablets, Integer planta) {
        this.id = id;
        this.numeroTablets = numeroTablets;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString()
    {
        return ""+ id + "";
    }
}
