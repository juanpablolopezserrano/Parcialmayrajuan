package com.ParcialMayraJuanPablo.app.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Cliente;
import com.ParcialMayraJuanPablo.app.entidades.Factura;
import com.ParcialMayraJuanPablo.app.entidades.Inventario;
import com.ParcialMayraJuanPablo.app.repositorio.ClienteRepository;
import com.ParcialMayraJuanPablo.app.repositorio.FacturaRepository;
import com.ParcialMayraJuanPablo.app.repositorio.InventarioRepository;


@Controller
public class FacturaControlador {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping({"/verFacturas", "/listarFacturas"})
    public String listarFacturas(Model model) {
        List<Factura> listaFacturas = facturaRepository.findAll();
        model.addAttribute("listaFacturas", listaFacturas);
        return "verFacturas";
    }

    @GetMapping("/verFacturas/formFactura")
    public String mostrarFormulario(Model model) {
        model.addAttribute("factura", new Factura());

        List<Cliente> listaClientes = clienteRepository.findAll();
        model.addAttribute("listaClientes", listaClientes);

        List<Inventario> listaInventario = inventarioRepository.findAll();
        model.addAttribute("listaInventario", listaInventario);

        return "formFactura";
    }

    @PostMapping("/guardarFactura")
    public String guardarFactura(Factura factura) {
        facturaRepository.save(factura);
        return "redirect:/verFacturas";
    }

    @GetMapping("/factura/editar/{id}")
    public String modificarFactura(@PathVariable("id") Long id, Model model) {
        Factura factura = facturaRepository.findById(id).get();
        model.addAttribute("factura", factura);

        List<Cliente> listaClientes = clienteRepository.findAll();
        model.addAttribute("listaClientes", listaClientes);

        List<Inventario> listaInventario = inventarioRepository.findAll();
        model.addAttribute("listaInventario", listaInventario);

        return "formFactura";
    }

    @GetMapping("/factura/eliminar/{id}")
    public String eliminarFactura(@PathVariable("id") Long id) {
        facturaRepository.deleteById(id);
        return "redirect:/verFacturas";
    }
}

