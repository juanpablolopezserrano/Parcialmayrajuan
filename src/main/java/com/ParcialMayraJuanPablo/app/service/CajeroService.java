package com.ParcialMayraJuanPablo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParcialMayraJuanPablo.app.entidades.Cajero;
import com.ParcialMayraJuanPablo.app.repositorio.CajeroRepository;

@Service
public class CajeroService {

    @Autowired
    private CajeroRepository cajeroRepository;

    public Cajero guardarCajero(Cajero cajero) {
        return cajeroRepository.save(cajero);
    }
}