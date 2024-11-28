package com.ParcialMayraJuanPablo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParcialMayraJuanPablo.app.entidades.Admin;
import com.ParcialMayraJuanPablo.app.entidades.Cajero;
import com.ParcialMayraJuanPablo.app.entidades.Cliente;
import com.ParcialMayraJuanPablo.app.entidades.Contador;
import com.ParcialMayraJuanPablo.app.repositorio.AdminRepository;
import com.ParcialMayraJuanPablo.app.repositorio.CajeroRepository;
import com.ParcialMayraJuanPablo.app.repositorio.ClienteRepository;
import com.ParcialMayraJuanPablo.app.repositorio.ContadorRepository;

@Service
public class LoginService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CajeroRepository cajeroRepository;

    @Autowired
    private ContadorRepository contadorRepository;

    public String validarUsuario(String usuario, String contrasena) {
        // Verificar en la tabla de Clientes
        Cliente cliente = clienteRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (cliente != null) {
            return "cliente";
        }

        // Verificar en la tabla de Admin
        Admin admin = adminRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (admin != null) {
            return "admin";
        }

        // Verificar en la tabla de Cajero
        Cajero cajero = cajeroRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (cajero != null) {
            return "cajero";
        }

        // Verificar en la tabla de Contador
        Contador contador = contadorRepository.findByUsuarioAndContrasena(usuario, contrasena);
        if (contador != null) {
            return "contador";
        }

        // Si no se encuentra el usuario
        return "invalido";
    }
}
