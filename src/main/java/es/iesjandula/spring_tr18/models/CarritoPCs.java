package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_pcs")
public class CarritoPCs {
    @Id
    @Column(length = 10)
    private Integer id;
    @Column(length = 3, nullable = false)
    private Integer numeroPcs;
    @Column(length = 1, nullable = false)
    private Integer planta;
    @Column(length = 50, nullable = false)
    private String sistemaOperativo;

    public CarritoPCs()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroPcs() {
        return numeroPcs;
    }

    public void setNumeroPcs(Integer numero_pcs) {
        this.numeroPcs = numero_pcs;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistema_operativo) {
        this.sistemaOperativo = sistema_operativo;
    }

    
}
