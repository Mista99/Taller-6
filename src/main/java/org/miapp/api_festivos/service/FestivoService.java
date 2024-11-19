package org.miapp.api_festivos.service;

import org.miapp.api_festivos.PascuaCalculator;
import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class FestivoService {

    @Autowired
    private FestivoRepository festivoRepository;

    // @Autowired
    // private TipoRepository tipoRepository;
    public List<Festivo> obtenerFestivosTipo1() {
        return festivoRepository.findByTipo_Id(1L);    
    }
    public List<Festivo> obtenerFestivosTipo2() {
        return festivoRepository.findByTipo_Id(2L);    
    }
    public List<Festivo> obtenerFestivosTipo3() {
        return festivoRepository.findByTipo_Id(3L);    
    }
    public List<Festivo> obtenerFestivosTipo4() {
        return festivoRepository.findByTipo_Id(4L);    
    }
    public boolean esFestivo(int anio, int mes, int dia) {
        // Obtener los festivos de tipo 3 y tipo 4
        List<Festivo> festivos3 = obtenerFestivosTipo3();
        List<Festivo> festivos4 = obtenerFestivosTipo4();
        
        // Calcular la fecha de la Pascua para el año proporcionado
        LocalDate pascua1 = PascuaCalculator.calcularPascua(anio);
        
        // Recorrer los festivos tipo 3 y calcular la fecha de Pascua con los días adicionales
        for (Festivo festivo : festivos3) {
            LocalDate fechaPascuaConDias = pascua1.plusDays(festivo.getDiasPascua());
            
            // Verificar si la fecha calculada de la Pascua con días adicionales coincide con el día, mes y año
            if (fechaPascuaConDias.getYear() == anio && fechaPascuaConDias.getMonthValue() == mes && fechaPascuaConDias.getDayOfMonth() == dia) {
                return true;
            }
        }
    
        // Recorrer los festivos tipo 4 y calcular la fecha de Pascua con los días adicionales
        for (Festivo festivo : festivos4) {
            LocalDate fechaPascuaConDias = pascua1.plusDays(festivo.getDiasPascua());
            
            // Verificar si la fecha calculada de la Pascua con días adicionales coincide con el día, mes y año
            if (fechaPascuaConDias.getYear() == anio && fechaPascuaConDias.getMonthValue() == mes && fechaPascuaConDias.getDayOfMonth() == dia) {
                return true;
            }
        }
    
        // Verificar si algún festivo de tipo 1 coincide con el día y mes (son fijos durante todo el año)
        List<Festivo> festivos1 = obtenerFestivosTipo1();  // Obtener los festivos de tipo 1 (constantes durante el año)
        for (Festivo festivo : festivos1) {
            if (festivo.getDia() == dia && festivo.getMes() == mes) {
                return true;
            }
        }
    
        // Verificar si algún festivo de tipo 2 coincide con el día y mes (son fijos durante el año)
        List<Festivo> festivos2 = obtenerFestivosTipo2();  // Obtener los festivos de tipo 2 (constantes durante el año)
        for (Festivo festivo : festivos2) {
            if (festivo.getDia() == dia && festivo.getMes() == mes) {
                return true;
            }
        }
    
        // Si no hay coincidencia, devolver falso
        return false;
    }
    
}
