package es.iesjandula.spring_tr18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.spring_tr18.models.ReservaCarritoPCs;
/**
 * This class allows execute the orders of database
 * @author Manuel Canio Gil
 * @version 1.1.1
 */
@Repository
public interface IReservaCarritoPCsRepository extends JpaRepository<ReservaCarritoPCs, Long>
{
    
}
