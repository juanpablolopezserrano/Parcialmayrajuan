package com.ParcialMayraJuanPablo.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    // Puedes buscar facturas por cliente o inventario si lo necesitas:
    List<Factura> findByClienteId(Long clienteId);
    List<Factura> findByInventarioId(Long inventarioId);
}

