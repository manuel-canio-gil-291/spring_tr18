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
 * This is the table "Teacher"
 * @author Manuel Canio Gil
 * @version 1.3.1
 */
@Entity
@Table(name = "profesores")
public class Profesor 
{
    /**
     * Unique ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Name of the teacher
     */
    @Column(length = 20, nullable = false)
    private String nombre;
    /**
     * Surname of the teacher
     */
    @Column(length = 40, nullable = false)
    private String apellidos;
    /**
     * Empty constructor
     */
    public Profesor()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param nombre
     * @param apellidos
     */
    public Profesor(Long id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    /**
     * @return the ID of the teacher
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID for the teacher
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name of the teacher
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set the name of the teacher
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the surname of the teacher
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Set the surname of the teacher
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * Convert the instance to String, it's necessary to view the ID of the teacher in every reserve
     */
    @Override
    public String toString()
    {
        return ""+id+"";
    }
}
