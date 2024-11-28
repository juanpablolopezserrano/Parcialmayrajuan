package com.ParcialMayraJuanPablo.app.controlador;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Cajero;
import com.ParcialMayraJuanPablo.app.repositorio.CajeroRepository;
import com.ParcialMayraJuanPablo.app.service.CajeroService;



@Controller
@RequestMapping("/cajero")
public class CajeroControlador {

    @Autowired
    private CajeroRepository cajeroRepository;
    @Autowired
    private CajeroService cajeroService;

    @PostMapping("/registroCajero")
    public String registroCajero(Cajero Cajero, Model model) {
        cajeroService.guardarCajero(Cajero);
        model.addAttribute("mensaje", "Cajero registrado exitosamente.");
        return "ExitoCajero";
    }

}

