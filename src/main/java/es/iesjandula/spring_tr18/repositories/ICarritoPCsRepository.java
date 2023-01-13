package es.iesjandula.spring_tr18.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.spring_tr18.models.CarritoPCs;

public interface ICarritoPCsRepository
{
    @Query("SELECT * FROM carritos_pcs WHERE planta = :planta")
    public List<CarritoPCs> buscarCarritoPCsPorPlanta(@Param("planta") Integer planta);

    @Query("SELECT * FROM carritos_pcs WHERE sistema_operativo LIKE :sistema_operativo")
    public List<CarritoPCs> buscarCarritoPCsPorSistemaOperativo(@Param("sistema_operativo") String sistemaOperativo);
}
