package es.iesjandula.spring_tr18.models;

public class Carrito_PCs {
    private Integer id;
    private Integer numero_pcs, planta;
    private String sistema_operativo;

    public Carrito_PCs()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_pcs() {
        return numero_pcs;
    }

    public void setNumero_pcs(Integer numero_pcs) {
        this.numero_pcs = numero_pcs;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    
}
