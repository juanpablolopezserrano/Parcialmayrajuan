package com.ParcialMayraJuanPablo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParcialMayraJuanPablo.app.entidades.Inventario;
import com.ParcialMayraJuanPablo.app.repositorio.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
    private InventarioRepository inventarioRepository;

    // Registrar un nuevo producto en el inventario
    public void registrarInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    // Obtener todos los inventarios
    public List<Inventario> obtenerInventarios() {
        return inventarioRepository.findAll();
    }
 // Obtener un inventario por su ID
    public Inventario obtenerInventarioPorId(Long id) {
        return inventarioRepository.findById(id).orElse(null);  // Devuelve el inventario con ese ID
    }

    // Actualizar el inventario
    public void actualizarInventario(Long id, Inventario inventario) {
        Inventario inventarioExistente = inventarioRepository.findById(id).orElse(null);
        if (inventarioExistente != null) {
            // Actualiza los campos del inventario
            inventarioExistente.setNombrep(inventario.getNombrep());
            inventarioExistente.setCantidadp(inventario.getCantidadp());
            inventarioExistente.setPreciop(inventario.getPreciop());
            inventarioRepository.save(inventarioExistente);  // Guarda el inventario actualizado
        }
    }
    
    public void actualizarInventario(Inventario inventario) {
        inventarioRepository.save(inventario); // Guarda el inventario actualizado
    }

	public void actualizarInventario(Long id, String nombre, int cantidad, double precio) {
		// TODO Auto-generated method stub
		
	}
	
	public Inventario obtenerInventarioPorId1(Long id) {
	    return inventarioRepository.findById(id).orElse(null);
	}
	 public List<Inventario> obtenerTodosLosInventarios() {
	        return inventarioRepository.findAll();  // Retorna todos los productos
	    }

	    // Método para eliminar un producto por su id
	    public boolean eliminarProducto(int id) {
	        try {
	            inventarioRepository.deleteById((long) id);  // Elimina el producto usando el ID
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;  // Si ocurre un error, retorna false
	        }
	    }
	    public boolean eliminarInventario(Long id) {
	        try {
	            // Verifica si el inventario existe antes de eliminarlo
	            if (inventarioRepository.existsById(id)) {
	                inventarioRepository.deleteById(id);  // Elimina el inventario
	                return true;
	            }
	            return false;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;  // Si ocurre un error, retorna false
	        }
	    }

	
}
