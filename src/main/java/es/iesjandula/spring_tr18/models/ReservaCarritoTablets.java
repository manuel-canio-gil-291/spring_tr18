package es.iesjandula.spring_tr18.models;

import java.util.Date;

public class ReservaCarritoTablets {
    private Integer id;
    private Profesor idProfesor;
    private CarritoTablets idCarritoTablets;
    private String ubicacionPrestamo;
    private Date fecha;

    public ReservaCarritoTablets()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor id_profesor) {
        this.idProfesor = id_profesor;
    }

    public CarritoTablets getIdCarritoTablets() {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(CarritoTablets id_carrito_tablets) {
        this.idCarritoTablets = id_carrito_tablets;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacion_prestamo) {
        this.ubicacionPrestamo = ubicacion_prestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
