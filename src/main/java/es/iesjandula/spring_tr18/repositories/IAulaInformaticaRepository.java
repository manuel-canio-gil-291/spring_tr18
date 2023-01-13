package es.iesjandula.spring_tr18.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.spring_tr18.models.AulaInformatica;

public interface IAulaInformaticaRepository
{
    @Query("SELECT * FROM aulas_informatica ai WHERE ai.numero_aula = :numero_aula")
    public List<AulaInformatica> buscarAulaInformaticaPorPlanta(@Param("numero_aula") Integer numeroAula);    
}
