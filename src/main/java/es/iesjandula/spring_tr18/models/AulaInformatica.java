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
 * This is the table "TIC classroom"
 * @author Manuel Canio Gil
 * @version 1.4.0
 */
@Entity
@Table(name = "aulas_informatica")
public class AulaInformatica 
{
    /**
     * Unique ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The number of the classroom
     */
    @Column(length = 2)
    private Integer numeroAula;
    /**
     * The floor
     */
    @Column(length = 1, nullable = false)
    private Integer planta;
    /**
     * Empty constructor
     */
    public AulaInformatica()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param numeroAula
     * @param planta
     */
    public AulaInformatica(Long id, Integer numeroAula, Integer planta) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.planta = planta;
    }
    /**
     * @return the ID of the classroom
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID of the classroom
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the number of the classroom
     */
    public Integer getNumeroAula() {
        return numeroAula;
    }
    /**
     * Set the number of the classroom
     * @param numero_aula
     */
    public void setNumeroAula(Integer numero_aula) {
        this.numeroAula = numero_aula;
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
     * Convert the instance to String, it's necessary to view the ID of the classroom in every reserve
     */
    @Override
    public String toString()
    {
        return ""+ id + "";
    }

}
