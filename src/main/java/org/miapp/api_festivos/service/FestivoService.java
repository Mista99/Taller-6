package org.miapp.api_festivos.service;

import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FestivoService {

    @Autowired
    private FestivoRepository festivoRepository;

    public boolean esFestivo(int dia, int mes) {
        Optional<Festivo> festivo = festivoRepository.findByDiaAndMes(dia, mes);
        return festivo.isPresent();
    }

    public Optional<Festivo> obtenerFestivo(int dia, int mes) {
        return festivoRepository.findByDiaAndMes(dia, mes);
    }
}
