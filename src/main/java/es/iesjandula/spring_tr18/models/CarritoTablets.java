/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * This is the table "Tablet trolley"
 * @author Manuel Canio Gil
 * @version 1.1.1
 */
@Entity
@Table(name = "carritos_tablets")
public class CarritoTablets 
{
    /**
     * Unique ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Number of the tablets
     */
    @Column(length = 3)
    private Integer numeroTablets;
    /**
     * The floor
     */
    @Column(length = 1, nullable = false)
    private Integer planta;
    /**
     * Empty constructor
     */
    public CarritoTablets()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param numeroTablets
     * @param planta
     */
    public CarritoTablets(Long id, Integer numeroTablets, Integer planta) {
        this.id = id;
        this.numeroTablets = numeroTablets;
        this.planta = planta;
    }
    /**
     * @return the ID of the tablet trolley
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID of the tablet trolley
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the number of the tablets
     */
    public Integer getNumeroTablets() {
        return numeroTablets;
    }
    /**
     * Set the number of the tablets
     * @param numero_tablets
     */
    public void setNumeroTablets(Integer numero_tablets) {
        this.numeroTablets = numero_tablets;
    }
    /**
     * @return the floor that it's located
     */
    public Integer getPlanta() {
        return planta;
    }
    /**
     * Set the floor that it's located
     * @param planta
     */
    public void setPlanta(Integer planta) {
        this.planta = planta;
    }
    /**
     * Convert the instance to String, it's necessary to view the ID of the tablet trolley in every reserve
     */
    @Override
    public String toString()
    {
        return ""+ id + "";
    }
}
