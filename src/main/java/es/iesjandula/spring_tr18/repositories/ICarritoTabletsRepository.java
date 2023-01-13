package es.iesjandula.spring_tr18.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.spring_tr18.models.CarritoTablets;

public interface ICarritoTabletsRepository
{
    @Query("SELECT * FROM carritos_tablets WHERE planta = :planta")
    public List<CarritoTablets> buscarCarritoTabletsPorPlanta(@Param("planta") Integer planta);    
}
