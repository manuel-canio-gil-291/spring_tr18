package es.iesjandula.spring_tr18.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.spring_tr18.models.ReservaAula;

@Repository
public interface IReservaAula extends JpaRepository<ReservaAula, Date>
{
    
}
