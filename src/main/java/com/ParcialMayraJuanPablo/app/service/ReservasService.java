package com.ParcialMayraJuanPablo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParcialMayraJuanPablo.app.entidades.Reserva;
import com.ParcialMayraJuanPablo.app.repositorio.ReservaRepository;

@Service
public class ReservasService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
