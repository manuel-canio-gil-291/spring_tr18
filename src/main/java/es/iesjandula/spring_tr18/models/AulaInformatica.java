package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula_informatica")
public class AulaInformatica 
{
    @Id
    @Column(length = 10)
    private Integer id;
    @Column(length = 2)
    private Integer numeroAula;
    @Column(length = 1)
    private Integer planta;
    
    public AulaInformatica()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    
}
