package com.ParcialMayraJuanPablo.app.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParcialMayraJuanPablo.app.entidades.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Método para buscar reservas por área o fecha
    List<Reserva> findByArea(String area);
    List<Reserva> findByFecha(Date fecha);
}

