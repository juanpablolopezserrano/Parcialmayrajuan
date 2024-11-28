package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroReservasController {

    @GetMapping("/registroReservas")
    public String registroReservas() {
        return "registroReservas"; // Busca en templates/registroReservas.html
    }
}
