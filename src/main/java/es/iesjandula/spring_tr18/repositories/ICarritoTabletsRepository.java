/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.spring_tr18.models.CarritoTablets;
/**
 * This class allows execute the orders of database
 * @author Manuel Canio Gil
 * @version 1.3.0
 */
@Repository
public interface ICarritoTabletsRepository extends JpaRepository<CarritoTablets, Long>
{
     
}
