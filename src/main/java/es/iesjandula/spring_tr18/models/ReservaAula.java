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
 * This is the table "Reserve classroom"
 * @author Manuel Canio Gil
 * @version 1.3.1
 */
@Entity
@Table(name = "reservas_aulas")
public class ReservaAula 
{  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    /**
     * The teacher ID
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profesor idProfesor;
    /**
     * The classroom ID
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AulaInformatica idAula;
    /**
     * The reserve date
     */
    @Column(name = "fecha", nullable = false)
    private String fecha;
    /**
     * Empty constructor
     */
    public ReservaAula()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param idProfesor
     * @param idAula
     * @param fecha
     */
    public ReservaAula(Long id, Profesor idProfesor, AulaInformatica idAula, String fecha) {
        this.id = id;
        this.idProfesor = idProfesor;
        this.idAula = idAula;
        this.fecha = fecha;
    }
    /**
     * @return the id of the TIC classroom reservation
     */
    public Long getId()
    {
        return id;
    }
    /**
     * Set the id of the TIC classroom reservation
     * @param id
     */
    public void setId(Long id)
    {
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
     * @return the classroom ID
     */
    public AulaInformatica getIdAula() {
        return idAula;
    }
    /**
     * Set the classroom ID
     * @param id_aula
     */
    public void setIdAula(AulaInformatica id_aula) {
        this.idAula = id_aula;
    }
    /**
     * @return the reserve date
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Set the reserve date
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}
