package es.iesjandula.spring_tr18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;

@Service
public class AulaInformaticaService 
{
    @Autowired
    IAulaInformaticaRepository aulaInformaticaRepository;
    
    public List<AulaInformatica> obtenerAulasInformatica()
    {
        return aulaInformaticaRepository.findAll();
    }

    public void guardarDatosAulaInformatica(AulaInformatica aulaInformatica)
    {
        aulaInformaticaRepository.save(aulaInformatica);
    }

    public AulaInformatica obtenerAulaInformaticaPorId(Long id)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.getReferenceById(id);

        if(aulaInformatica == null)
        {
            throw new RuntimeException("Aula no encontrada");
        }
        return aulaInformatica;
    }

    public void quitarAulaPorId(Long id)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.getReferenceById(id);

        if(aulaInformatica == null)
        {
            throw new RuntimeException("Aula no encontrada");
        }

        aulaInformaticaRepository.deleteById(id);
    }
}
