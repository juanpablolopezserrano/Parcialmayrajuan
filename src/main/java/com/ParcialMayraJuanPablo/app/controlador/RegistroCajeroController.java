package com.ParcialMayraJuanPablo.app.controlador;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroCajeroController {

    @GetMapping("/registroCajero")
    public String registroCajero() {
        return "registroCajero"; // Se busca en templates/registroCajero.html
    }
}

