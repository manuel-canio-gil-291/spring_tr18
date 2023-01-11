package es.iesjandula.spring_tr18.models;

public class Reserva_carrito_PCs {
    private Integer id;
    private Profesor id_profesor;
    private Carrito_PCs id_carrito_pcs;
    private String ubicacion_prestamo;

    public Reserva_carrito_PCs()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profesor getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Profesor id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Carrito_PCs getId_carrito_pcs() {
        return id_carrito_pcs;
    }

    public void setId_carrito_pcs(Carrito_PCs id_carrito_pcs) {
        this.id_carrito_pcs = id_carrito_pcs;
    }

    public String getUbicacion_prestamo() {
        return ubicacion_prestamo;
    }

    public void setUbicacion_prestamo(String ubicacion_prestamo) {
        this.ubicacion_prestamo = ubicacion_prestamo;
    }

    
}
