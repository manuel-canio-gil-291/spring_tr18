package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aulas_informatica")
public class AulaInformatica 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2)
    private Integer numeroAula;
    @Column(length = 1, nullable = false)
    private Integer planta;
    
    public AulaInformatica()
    {

    }

    public AulaInformatica(Long id, Integer numeroAula, Integer planta) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numero_aula) {
        this.numeroAula = numero_aula;
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
