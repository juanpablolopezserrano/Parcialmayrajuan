package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroContadorController {

    @GetMapping("/registroContador")
    public String registroContador() {
        return "registroContador"; // Busca en templates/registroContador.html
    }
}
