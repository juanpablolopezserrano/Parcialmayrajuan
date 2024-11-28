package com.ParcialMayraJuanPablo.app.controlador;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Contador;
import com.ParcialMayraJuanPablo.app.entidades.Inventario;
import com.ParcialMayraJuanPablo.app.service.ContadorService;
import com.ParcialMayraJuanPablo.app.service.InventarioService;



@Controller
@RequestMapping("/contador")
public class ContadorControlador {

    @Autowired
    private ContadorService contadorService;
    @Autowired
    private InventarioService inventarioService;

    @PostMapping("/registroContador")
    public String registroContador(Contador contador, Model model) {
        contadorService.guardarContador(contador);
        model.addAttribute("mensaje", "Contador registrado exitosamente.");
        return "ExitoContador";
    }
    
    @PostMapping("/crearInventario")
    public String crearInventario(Inventario inventario, Model model) {
        inventarioService.actualizarInventario(inventario);
        model.addAttribute("mensaje", "Inventario guardado exitosamente.");
        return "exito"; // Página de éxito (puedes cambiarla según sea necesario)
    }

    @GetMapping("/registroInventario")
    public String mostrarFormularioInventario() {
        return "registroInventario"; // Vista con formulario para crear inventario
    }

    @GetMapping
    public String paginaContador() {
        return "contador"; // Página principal del contador
    }
}

