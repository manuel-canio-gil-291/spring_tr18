package es.iesjandula.spring_tr18.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * This is the table "PC trolley"
 * @author Manuel Canio Gil
 * @version 1.0.0
 */
@Entity
@Table(name = "carritos_pcs")
public class CarritoPCs {
    /**
     * Unique ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The number of PCs
     */
    @Column(length = 3, nullable = false)
    private Integer numeroPcs;
    /**
     * The floor
     */
    @Column(length = 1, nullable = false)
    private Integer planta;
    /**
     * The operating system installed
     */
    @Column(length = 50, nullable = false)
    private String sistemaOperativo;
    /**
     * Empty constructor
     */
    public CarritoPCs()
    {

    }
    /**
     * Constructor with variables
     * @param id
     * @param numeroPcs
     * @param planta
     * @param sistemaOperativo
     */
    public CarritoPCs(Long id, Integer numeroPcs, Integer planta, String sistemaOperativo) {
        this.id = id;
        this.numeroPcs = numeroPcs;
        this.planta = planta;
        this.sistemaOperativo = sistemaOperativo;
    }
    /**
     * @return the ID of the PC trolley
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the ID of the PC trolley
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the number of PCs
     */
    public Integer getNumeroPcs() {
        return numeroPcs;
    }
    /**
     * Set the number of PCs
     * @param numero_pcs
     */
    public void setNumeroPcs(Integer numero_pcs) {
        this.numeroPcs = numero_pcs;
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
     * @return the operating system installed
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    /**
     * Set the name of the operating system installed
     * @param sistema_operativo
     */
    public void setSistemaOperativo(String sistema_operativo) {
        this.sistemaOperativo = sistema_operativo;
    }
    /**
     * Convert the instance to String, it's necessary to view the ID of the PC trolley in every reserve
     */
    @Override
    public String toString()
    {
        return ""+ id + "";
    }
}
