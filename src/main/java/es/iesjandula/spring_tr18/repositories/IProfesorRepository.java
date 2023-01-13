package es.iesjandula.spring_tr18.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.spring_tr18.models.Profesor;

public interface IProfesorRepository
{
    @Query("SELECT * FROM profesores p WHERE p.nombre LIKE :nombre")
    public List<Profesor> buscarPorNombre(@Param("nombre") String nombre);
}
