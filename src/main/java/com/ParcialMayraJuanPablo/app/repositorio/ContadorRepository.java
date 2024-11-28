package com.ParcialMayraJuanPablo.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Contador;

public interface ContadorRepository extends JpaRepository<Contador, Long> {
    // Método para buscar contadores por usuario
    Contador findByUsuarioAndContrasena(String usuario, String contrasena);
}

