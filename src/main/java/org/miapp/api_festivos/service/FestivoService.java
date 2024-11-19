package org.miapp.api_festivos.service;

import org.miapp.api_festivos.PascuaCalculator;
import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FestivoService {

    @Autowired
    private FestivoRepository festivoRepository;

    // @Autowired
    // private TipoRepository tipoRepository;
    
    public List<Festivo> obtenerFestivosTipo3() {
        return festivoRepository.findByTipo_Id(3L);    
    }
    public List<Festivo> obtenerFestivosTipo4() {
        return festivoRepository.findByTipo_Id(4L);    
    }
    
    public boolean esFestivo(int anio, int mes, int dia) {
        // Verificar los festivos fijos
        Optional<Festivo> festivo = festivoRepository.findByDiaAndMes(dia, mes);
        if (festivo.isPresent()) {
            return true; // Si hay un festivo fijo, devolver true
        }

        // Verificar festivos basados en Pascua
        LocalDate pascua = PascuaCalculator.calcularPascua(anio);
        if (mes == pascua.getMonthValue() && dia == pascua.getDayOfMonth()) {
            return true; // Si la fecha coincide con la Pascua, es festivo
        }
        return false; // Si no se encuentra ningún festivo, devolver false
    }
}
