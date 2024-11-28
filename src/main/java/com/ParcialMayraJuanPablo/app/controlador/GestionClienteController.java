package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GestionClienteController {

    @GetMapping("/gestioncliente")
    public String gestionCliente() {
        return "gestioncliente"; // Thymeleaf buscará en templates/gestioncliente.html
    }
}
