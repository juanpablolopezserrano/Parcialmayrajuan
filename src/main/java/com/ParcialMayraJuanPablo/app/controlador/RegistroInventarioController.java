package com.ParcialMayraJuanPablo.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroInventarioController {

    @GetMapping("/registroInventario")
    public String registroInventario() {
        return "registroInventario"; // Se busca en templates/registroInventario.html
    }
    
    @GetMapping("/editarInventario")
    public String editarInventario() {
        return "editarInventario"; // Se busca en templates/registroInventario.html
    }
    
}