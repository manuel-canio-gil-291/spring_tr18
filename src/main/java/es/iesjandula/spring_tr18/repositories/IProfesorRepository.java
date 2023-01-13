package es.iesjandula.spring_tr18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iesjandula.spring_tr18.models.Profesor;

@Repository
public interface IProfesorRepository extends JpaRepository<Profesor, Long>
{
    
}
