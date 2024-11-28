package com.ParcialMayraJuanPablo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ParcialMayraJuanPablo.app.entidades.Contador;
import com.ParcialMayraJuanPablo.app.repositorio.ContadorRepository;

@Service
public class ContadorService {

    @Autowired
    private ContadorRepository contadorRepository;

    public Contador guardarContador(Contador contador) {
        return contadorRepository.save(contador);
    }
}
