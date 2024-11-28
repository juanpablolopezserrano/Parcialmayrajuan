package com.ParcialMayraJuanPablo.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ParcialMayraJuanPablo.app.entidades.Inventario;
import com.ParcialMayraJuanPablo.app.repositorio.InventarioRepository;
import com.ParcialMayraJuanPablo.app.service.InventarioService;

@Controller
@RequestMapping("/inventario")
public class InventarioControlador {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private InventarioRepository inventarioRepository;
    

    
    // Ruta para ver todos los productos
    @GetMapping("/verInventario")
    public String verInventario(Model model) {
        List<Inventario> inventarios = inventarioService.obtenerInventarios();
        model.addAttribute("inventarios", inventarios);
        return "verInventario"; // Nombre del JSP
    }

    // Ruta para mostrar el formulario de edición
    @GetMapping("/editarInventario/{id}")
    public String editarInventario(@PathVariable("id") Long id, Model model) {
        Inventario inventario = inventarioService.obtenerInventarioPorId(id);
        if (inventario != null) {
            model.addAttribute("inventario", inventario);  // Pasar el inventario para edición
            return "editarInventario";  // JSP para editar el inventario
        } else {
            return "redirect:/inventario/verInventario";  // Redirigir si no existe
        }
    }

    // Ruta para procesar la actualización del inventario (POST)
    @PostMapping("/editarInventario/{id}")
    public String actualizarInventario(@PathVariable("id") Long id, 
                                       @ModelAttribute("inventario") Inventario inventario, 
                                       Model model) {
        // Llamada al servicio para actualizar el inventario
        inventarioService.actualizarInventario(id, inventario);
        model.addAttribute("mensaje", "El inventario se actualizó correctamente.");
        return "redirect:/inventario/verInventario";  // Redirige a la lista después de guardar
    }

    // Ruta para registrar un nuevo inventario
    @PostMapping("/registroInventario")
    public String registroInventario(@ModelAttribute("inventario") Inventario inventario, Model model) {
        inventarioService.registrarInventario(inventario);
        model.addAttribute("mensaje", "Producto registrado exitosamente.");
        return "ExitoInventario"; // Redirigir a una página de éxito
    }

    // Ruta para procesar los datos enviados desde el formulario de edición (otra alternativa)
    @PostMapping("/editar")
    public String procesarEdicion(@RequestParam("id") Long id, 
                                   @RequestParam("nombre") String nombre, 
                                   @RequestParam("cantidad") int cantidad, 
                                   @RequestParam("precio") double precio, 
                                   Model model) {
        Inventario inventario = inventarioService.obtenerInventarioPorId(id);
        if (inventario != null) {
            inventario.setNombrep(nombre);
            inventario.setCantidadp(cantidad);
            inventario.setPreciop(precio);
            inventarioService.actualizarInventario(id, inventario);

            model.addAttribute("mensaje", "El inventario se actualizó correctamente.");
        } else {
            model.addAttribute("mensaje", "El inventario no se encontró.");
        }
        return "redirect:/inventario/verInventario"; // Redirige a la lista después de editar
    }
   
    @GetMapping("/inventario/eliminar/{id}")
    public String eliminarInventario(@PathVariable("id") Long id, Model model) {
        inventarioRepository.deleteById(id);
        return "redirect:/verInventario";
    }

   
}
