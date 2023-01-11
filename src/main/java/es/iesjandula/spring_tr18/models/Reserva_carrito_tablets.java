package es.iesjandula.spring_tr18.models;

public class Reserva_carrito_tablets {
    private Integer id;
    private Profesor id_profesor;
    private Carrito_tablets id_carrito_tablets;
    private String ubicacion_prestamo;

    public Reserva_carrito_tablets()
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

    public Carrito_tablets getId_carrito_tablets() {
        return id_carrito_tablets;
    }

    public void setId_carrito_tablets(Carrito_tablets id_carrito_tablets) {
        this.id_carrito_tablets = id_carrito_tablets;
    }

    public String getUbicacion_prestamo() {
        return ubicacion_prestamo;
    }

    public void setUbicacion_prestamo(String ubicacion_prestamo) {
        this.ubicacion_prestamo = ubicacion_prestamo;
    }

    
}
