package es.iesjandula.spring_tr18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.spring_tr18.models.CarritoTablets;

@Repository
public interface ICarritoTabletsRepository extends JpaRepository<CarritoTablets, Long>
{
     
}
