package es.iesjandula.spring_tr18.models;

public class CarritoPCs {
    private Integer id;
    private Integer numeroPcs, planta;
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
