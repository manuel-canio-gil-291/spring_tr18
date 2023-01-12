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
@Table(name = "reserva_carrito_pcs")
public class ReservaCarritoPCs {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor idProfesor;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CarritoPCs idCarritoPcs;
    @Column(name = "ubicacion_prestamo", length = 50)
    private String ubicacionPrestamo;
    @Column(nullable = false)
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
