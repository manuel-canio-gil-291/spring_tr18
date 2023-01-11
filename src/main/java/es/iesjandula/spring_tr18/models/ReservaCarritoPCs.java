package es.iesjandula.spring_tr18.models;

public class ReservaCarritoPCs {
    private Integer id;
    private Profesor idProfesor;
    private CarritoPCs idCarritoPcs;
    private String ubicacionPrestamo;

    public ReservaCarritoPCs()
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

    public CarritoPCs getIdCarritoPcs() {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(CarritoPCs id_carrito_pcs) {
        this.idCarritoPcs = id_carrito_pcs;
    }

    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }

    public void setUbicacionPrestamo(String ubicacion_prestamo) {
        this.ubicacionPrestamo = ubicacion_prestamo;
    }

    
}
