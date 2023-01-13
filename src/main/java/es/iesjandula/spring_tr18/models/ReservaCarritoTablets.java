package es.iesjandula.spring_tr18.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas_carritos_tablets")
public class ReservaCarritoTablets 
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor idProfesor;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CarritoTablets idCarritoTablets;
    @Column(name = "ubicacion_prestamo", length = 50)
    private String ubicacionPrestamo;
    @Column(nullable = false)
    private Date date;

    public ReservaCarritoTablets()
    {

    }

    public ReservaCarritoTablets(Long id, Profesor idProfesor, CarritoTablets idCarritoTablets,
            String ubicacionPrestamo, Date date) {
        this.id = id;
        this.idProfesor = idProfesor;
        this.idCarritoTablets = idCarritoTablets;
        this.ubicacionPrestamo = ubicacionPrestamo;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
