package es.iesjandula.spring_tr18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IProfesorRepository;

@Service
public class ProfesorService 
{
    @Autowired
    IProfesorRepository profesorRepository;

    public List<Profesor> listarProfesores()
    {
        return profesorRepository.findAll();
    }

    public void guardarDatosProfesor(Profesor profesor)
    {
        profesorRepository.save(profesor);
    }

    public Profesor buscarProfesorPorId(Long id)
    {
        Profesor profesor = profesorRepository.getReferenceById(id);

        if(profesor == null)
        {
            throw new RuntimeException("No se ha encontrado el profesor que contenga el id "+id);
        }

        return profesor;
    }

    public void quitarProfesorPorId(Long id)
    {
        Profesor profesor = profesorRepository.getReferenceById(id);

        if(profesor == null)
        {
            throw new RuntimeException("No se ha encontrado el profesor que contenga el id "+id);
        }

        profesorRepository.deleteById(id);
    }
}
