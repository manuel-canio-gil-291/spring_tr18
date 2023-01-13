package es.iesjandula.spring_tr18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;

@Service
public class CarritoPCsService 
{
    @Autowired
    ICarritoPCsRepository carritoPCsRepository;

    public List<CarritoPCs> listarCarritosPCs()
    {
        return carritoPCsRepository.findAll();
    }

    public void guardarDatosCarritoPCs(CarritoPCs carritoPCs)
    {
        carritoPCsRepository.save(carritoPCs);
    }

    public CarritoPCs obtenerCarritoPCsPorId(Long id)
    {
        CarritoPCs carritoPCs = carritoPCsRepository.getReferenceById(id);

        if(carritoPCs == null)
        {
            throw new RuntimeException("No se ha podido encontrar el carrito");
        }

        return carritoPCs;
    }

    public void quitarCarritoPCsPorId(Long id)
    {
        CarritoPCs carritoPCs = carritoPCsRepository.getReferenceById(id);

        if(carritoPCs == null)
        {
            throw new RuntimeException("No se ha podido encontrar el carrito");
        }

        carritoPCsRepository.deleteById(id);
    }
}
