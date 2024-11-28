package com.ParcialMayraJuanPablo.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Cajero;

public interface CajeroRepository extends JpaRepository<Cajero, Long> {
    // Método para buscar cajeros por usuario
    Cajero findByUsuarioAndContrasena(String usuario, String contrasena);
}

