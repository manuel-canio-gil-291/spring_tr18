package es.iesjandula.spring_tr18.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.iesjandula.spring_tr18.models.ReservaAula;
import es.iesjandula.spring_tr18.models.ReservaCarritoPCs;
import es.iesjandula.spring_tr18.models.ReservaCarritoTablets;
import es.iesjandula.spring_tr18.repositories.IReservaAulaRepository;
import es.iesjandula.spring_tr18.repositories.IReservaCarritoPCsRepository;
import es.iesjandula.spring_tr18.repositories.IReservaCarritoTabletsRepository;

@Controller
public class WebController 
{
    @Autowired
    public IReservaCarritoTabletsRepository reservaCarritoTabletsRepository;

    @Autowired
    public IReservaCarritoPCsRepository reservaCarritoPCsRepository;

    @Autowired
    public IReservaAulaRepository reservaAulaRepository;

    @GetMapping("/reservas")
    public String paginaInicioReservas(Model model)
    {
        model.addAttribute("lista_reservas_aulas", reservaAulaRepository.findAll());
        model.addAttribute("lista_reservas_carritos_pcs", reservaCarritoPCsRepository.findAll());
        model.addAttribute("lista_reservas_carritos_tablets", reservaCarritoTabletsRepository.findAll());

        return "reservas_inicio";
    }

    @GetMapping("/reservas/formulario_nueva_reserva_aula")
    public String formularioNuevaReservaAula(Model model)
    {
        ReservaAula reservaAula = new ReservaAula();

        model.addAttribute("reserva_aula", reservaAula);

        return "nueva_reserva_aula";
    }

    @GetMapping("/reservas/formulario_nueva_reserva_carrito_pcs")
    public String formularioNuevaReservaCarritoPCs(Model model)
    {
        ReservaCarritoPCs reservaCarritoPCs = new ReservaCarritoPCs();

        model.addAttribute("reserva_carrito_pcs", reservaCarritoPCs);

        return "nueva_reserva_carrito_pcs";
    }

    @GetMapping("/reservas/formulario_nueva_reserva_carrito_tablets")
    public String formularioNuevaReservaCarritoTablets(Model model)
    {
        ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets();

        model.addAttribute("reserva_carrito_tablets", reservaCarritoTablets);

        return "nueva_reserva_carrito_tablets";
    }

    @PostMapping("/reservas/guardar_reserva_aula")
    public String guardarReservaAula(@ModelAttribute("reserva_aula") ReservaAula reservaAula)
    {
        reservaAulaRepository.save(reservaAula);

        return "redirect:/reservas";
    }

    @PostMapping("/reservas/guardar_reserva_carrito_pcs")
    public String guardarReservaCarritoPCs(@ModelAttribute("reserva_carrito_pcs") ReservaCarritoPCs reservaCarritoPCs)
    {
        reservaCarritoPCsRepository.save(reservaCarritoPCs);

        return "redirect:/reservas";
    }

    @PostMapping("/reservas/guardar_reserva_carrito_tablets")
    public String guardarReservaCarritoTablets(@ModelAttribute("reserva_carrito_tablets") ReservaCarritoTablets reservaCarritoTablets)
    {
        reservaCarritoTabletsRepository.save(reservaCarritoTablets);

        return "redirect:/reservas";
    }

    @GetMapping("/reservas/formulario_actualizar_reserva_aula/{date}")
    public String formularioActualizarReservaAula(@PathVariable("date") Date date, Model model)
    {
        ReservaAula reservaAula = reservaAulaRepository.findById(date).orElseThrow(() -> new IllegalArgumentException("La fecha de reserva "+date+" no es valida"));

        model.addAttribute("reserva_aula", reservaAula);

        return "actualizar_reserva_aula";
    }

    @GetMapping("/reservas/formulario_actualizar_reserva_carrito_tablets/{id}")
    public String formularioActualizarReservaCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        ReservaCarritoTablets reservaCarritoTablets = reservaCarritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se pudo encontrar la reserva del carrito de tablets numero "+id));

        model.addAttribute("reserva_carrito_tablets", reservaCarritoTablets);

        return "actualizar_reserva_carrito_tablets";
    }

    @GetMapping("/reservas/formulario_actualizar_reserva_carrito_pcs/{id}")
    public String formularioActualizarReservaCarritoPCs(@PathVariable("id") Long id, Model model)
    {
        ReservaCarritoPCs reservaCarritoPCs = reservaCarritoPCsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se pudo encontrar la reserva del carrito de ordenadores numero "+id));

        model.addAttribute("reserva_carrito_pcs", reservaCarritoPCs);

        return "actualizar_reserva_carrito_pcs";
    }

    @PostMapping("/reservas/actualizar_reserva_aula/{date}")
    public String actualizarReservaAula(@PathVariable("date") Date date, ReservaAula reservaAula,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaAula.setFecha(date);

            return "actualizar_reserva_carrito_pcs";
        }

        reservaAulaRepository.save(reservaAula);

        return "redirect:/reservas";
    }

    @PostMapping("/reservas/actualizar_reserva_carrito_tablets/{id}")
    public String actualizarReservaCarritoTablets(@PathVariable("id") Long id, ReservaCarritoTablets reservaCarritoTablets,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaCarritoTablets.setId(id);

            return "actualizar_reserva_carrito_tablets";
        }

        reservaCarritoTabletsRepository.save(reservaCarritoTablets);

        return "redirect:/reservas";
    }

    @PostMapping("/reservas/actualizar_reserva_carrito_pcs/{id}")
    public String actualizarReservaCarritoPCs(@PathVariable("id") Long id, ReservaCarritoPCs reservaCarritoPCs,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaCarritoPCs.setId(id);

            return "actualizar_reserva_carrito_pcs";
        }

        reservaCarritoPCsRepository.save(reservaCarritoPCs);

        return "redirect:/reservas";
    }

    @GetMapping("/reservas/anular_reserva_aula/{date}")
    public String anularReservaAula(@PathVariable("date") Date date, Model model)
    {
        ReservaAula reservaAula = reservaAulaRepository.findById(date).orElseThrow(() -> new IllegalArgumentException("La fecha de reserva "+date+" no es valida"));

        reservaAulaRepository.delete(reservaAula);

        return "redirect:/reservas";
    }

    @GetMapping("/reservas/anular_reserva_carrito_tablets/{id}")
    public String anularReservaCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        ReservaCarritoTablets reservaCarritoTablets = reservaCarritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se pudo encontrar la reserva del carrito de tablets numero "+id));

        reservaCarritoTabletsRepository.delete(reservaCarritoTablets);

        return "redirect:/reservas";
    }

    @GetMapping("/reservas/anular_reserva_carrito_pcs/{id}")
    public String anularReservaCarritoPCs(@PathVariable("id") Long id, Model model)
    {
        ReservaCarritoPCs reservaCarritoPCs = reservaCarritoPCsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se pudo encontrar la reserva del carrito de ordenadores numero "+id));

        reservaCarritoPCsRepository.delete(reservaCarritoPCs);

        return "redirect:/reservas";
    }
}
