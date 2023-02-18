/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * This is the table "Reserve tablet trolley"
 * @author Manuel Canio Gil
 * @version 1.4.0
 */
@Entity
@Table(name = "reservas_carritos_tablets")
public class ReservaCarritoTablets 
{
    /**
     * Reserve ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Teacher ID
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor idProfesor;
    /**
     * Tablet trolley ID
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CarritoTablets idCarritoTablets;
    /**
     * The loan location
     */
    @Column(name = "ubicacion_prestamo", length = 50)
    private String ubicacionPrestamo;
    /**
     * Reserve date
     */
    @Column(nullable = false)
    private String date;
    /**
     * Empty constructor
     */
    public ReservaCarritoTablets()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param idProfesor
     * @param idCarritoTablets
     * @param ubicacionPrestamo
     * @param date
     */
    public ReservaCarritoTablets(Long id, Profesor idProfesor, CarritoTablets idCarritoTablets,
            String ubicacionPrestamo, String date) {
        this.id = id;
        this.idProfesor = idProfesor;
        this.idCarritoTablets = idCarritoTablets;
        this.ubicacionPrestamo = ubicacionPrestamo;
        this.date = date;
    }
    /**
     * @return the reserve ID
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the reserve ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the teacher ID
     */
    public Profesor getIdProfesor() {
        return idProfesor;
    }
    /**
     * Set the teacher ID
     * @param id_profesor
     */
    public void setIdProfesor(Profesor id_profesor) {
        this.idProfesor = id_profesor;
    }
    /**
     * @return the tablet trolley ID
     */
    public CarritoTablets getIdCarritoTablets() {
        return idCarritoTablets;
    }
    /**
     * Set the tablet trolley ID
     * @param id_carrito_tablets
     */
    public void setIdCarritoTablets(CarritoTablets id_carrito_tablets) {
        this.idCarritoTablets = id_carrito_tablets;
    }
    /**
     * @return the loan location
     */
    public String getUbicacionPrestamo() {
        return ubicacionPrestamo;
    }
    /**
     * Set the loan location
     * @param ubicacion_prestamo
     */
    public void setUbicacionPrestamo(String ubicacion_prestamo) {
        this.ubicacionPrestamo = ubicacion_prestamo;
    }
    /**
     * @return the reserve date
     */
    public String getDate() {
        return date;
    }
    /**
     * Set the reserve date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
