package com.ParcialMayraJuanPablo.app.service;

import com.ParcialMayraJuanPablo.app.entidades.Cliente;
import com.ParcialMayraJuanPablo.app.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Iterable<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
        
    }

	
	   public void registrarCliente() {
	        // Lógica para registrar un cliente (por ahora solo un mensaje)
	        System.out.println("Registro de cliente procesado.");
	    }
    
    
}
