package com.ParcialMayraJuanPablo.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Método para buscar inventario por nombre del producto
    Inventario findByNombrep(String nombrep);
}

