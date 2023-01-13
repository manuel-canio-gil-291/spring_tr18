package es.iesjandula.spring_tr18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.spring_tr18.models.CarritoTablets;
import es.iesjandula.spring_tr18.repositories.ICarritoTabletsRepository;

@Service
public class CarritoTabletsService 
{
    @Autowired
    ICarritoTabletsRepository carritoTabletsRepository;

    public List<CarritoTablets> listarCarritosTablets()
    {
        return carritoTabletsRepository.findAll();
    }

    public void guardarDatosCarritoTablets(CarritoTablets carritoTablets)
    {
        carritoTabletsRepository.save(carritoTablets);
    }

    public CarritoTablets obtenerCarritoTabletsPorId(Long id)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.getReferenceById(id);

        if(carritoTablets == null)
        {
            throw new RuntimeException("No se ha podido encontrar el carrito");
        }

        return carritoTablets;
    }

    public void quitarCarritoTabletsPorId(Long id)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.getReferenceById(id);

        if(carritoTablets == null)
        {
            throw new RuntimeException("No se ha podido encontrar el carrito");
        }

        carritoTabletsRepository.deleteById(id);
    }
}
