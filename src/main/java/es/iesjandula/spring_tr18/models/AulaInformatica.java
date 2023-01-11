package es.iesjandula.spring_tr18.models;

public class AulaInformatica 
{
    private Integer id;
    private Integer numeroAula, planta;
    
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
