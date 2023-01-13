package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritos_pcs")
public class CarritoPCs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3, nullable = false)
    private Integer numeroPcs;
    @Column(length = 1, nullable = false)
    private Integer planta;
    @Column(length = 50, nullable = false)
    private String sistemaOperativo;

    public CarritoPCs()
    {

    }

    public CarritoPCs(Long id, Integer numeroPcs, Integer planta, String sistemaOperativo) {
        this.id = id;
        this.numeroPcs = numeroPcs;
        this.planta = planta;
        this.sistemaOperativo = sistemaOperativo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
