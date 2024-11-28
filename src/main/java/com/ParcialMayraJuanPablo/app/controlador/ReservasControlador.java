package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Reserva;
import com.ParcialMayraJuanPablo.app.service.ReservasService;



@Controller
@RequestMapping("/reservas")
public class ReservasControlador {

    @Autowired
    private ReservasService reservasService;

    @PostMapping("/registroReservas")
    public String registroReservas(Reserva reserva, Model model) {
        reservasService.guardarReserva(reserva);
        model.addAttribute("mensaje", "Reserva registrada exitosamente.");
        return "ExitoReservas";
    }
}
