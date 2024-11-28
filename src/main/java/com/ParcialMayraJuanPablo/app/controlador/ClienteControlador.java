package com.ParcialMayraJuanPablo.app.controlador;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Cliente;
import com.ParcialMayraJuanPablo.app.repositorio.ClienteRepository;
import com.ParcialMayraJuanPablo.app.service.ClienteService;



@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crearCliente")
    public String crearCliente(Cliente cliente, Model model) {
        clienteService.guardarCliente(cliente);
        model.addAttribute("mensaje", "Cliente guardado exitosamente.");
        return "exito"; // Página de éxito (puedes cambiarla según sea necesario)
    }
    
    @GetMapping
    public String clientePage() {
        return "cliente"; // Si usas Thymeleaf, este es el nombre de la vista sin ".html"
    }

    
}
