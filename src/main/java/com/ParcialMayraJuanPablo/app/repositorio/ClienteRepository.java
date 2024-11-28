package com.ParcialMayraJuanPablo.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados aquí, por ejemplo:
    Cliente findByUsuarioAndContrasena(String usuario, String contrasena);
}

