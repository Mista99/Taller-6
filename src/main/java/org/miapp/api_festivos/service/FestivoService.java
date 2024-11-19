package org.miapp.api_festivos.service;

import org.miapp.api_festivos.PascuaCalculator;
import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
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

    public String validarFecha(int anio, int mes, int dia) {
        try {
            // Intentamos crear la fecha con el año, mes y día proporcionados
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            return "Fecha válida: ";
        } catch (DateTimeException e) {
            return "Fecha No Válida";
        }
    }
    
    public boolean esFestivo(int anio, int mes, int dia) {
        // Obtener los festivos de tipo 3 y tipo 4
        List<Festivo> festivos1 = obtenerFestivosTipo1();  // Obtener los festivos de tipo 1 (constantes durante el año)
        List<Festivo> festivos2 = obtenerFestivosTipo2();  // Obtener los festivos de tipo 2 (constantes durante el año)
        List<Festivo> festivos3 = obtenerFestivosTipo3();
        List<Festivo> festivos4 = obtenerFestivosTipo4();
        
        // Verificar si algún festivo de tipo 1 coincide con el día y mes (son fijos durante todo el año)
        for (Festivo festivo : festivos1) {
            if (festivo.getDia() == dia && festivo.getMes() == mes) {
                return true;
            }
        }
        // Recorrer los festivos tipo 2 (fijos durante el año)
        for (Festivo festivo : festivos2) {
            // Crear la fecha del festivo con el día y mes proporcionado (para el año actual)
            LocalDate fechaFestivo = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
            
            // Trasladar la fecha al siguiente lunes si no cae en lunes
            if (fechaFestivo.getDayOfWeek() != DayOfWeek.MONDAY) {
                fechaFestivo = fechaFestivo.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
            
            // Verificar si la fecha ajustada coincide con la fecha proporcionada
            if (fechaFestivo.getYear() == anio && fechaFestivo.getMonthValue() == mes && fechaFestivo.getDayOfMonth() == dia) {
                return true; // El festivo coincide con la fecha dada
            }
        }
        
        // Calcular la fecha de la Pascua para el año proporcionado
        LocalDate pascua1 = PascuaCalculator.calcularPascua(anio);
        // Recorrer los festivos tipo 3 y calcular la fecha de Pascua con los días adicionales
        for (Festivo festivo : festivos3) {
            LocalDate fechaPascuaConDias = pascua1.plusDays(festivo.getDiasPascua());
            
            // se compara la fecha calculada del festivo con la ingresada por el usuario
            if (fechaPascuaConDias.getYear() == anio && fechaPascuaConDias.getMonthValue() == mes && fechaPascuaConDias.getDayOfMonth() == dia) {
                return true;
            }
        }
        
        // Recorrer los festivos tipo 4 y calcular la fecha de Pascua con los días adicionales
        for (Festivo festivo : festivos4) {
            // Calcular la fecha de Pascua con los días adicionales
            LocalDate fechaPascuaConDias = pascua1.plusDays(festivo.getDiasPascua());

            // Trasladar la fecha al siguiente lunes si no cae en lunes
            if (fechaPascuaConDias.getDayOfWeek() != DayOfWeek.MONDAY) {
                fechaPascuaConDias = fechaPascuaConDias.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }

            // Se compara la fecha calculada del festivo con la ingresada por el usuario
            if (fechaPascuaConDias.getYear() == anio && fechaPascuaConDias.getMonthValue() == mes && fechaPascuaConDias.getDayOfMonth() == dia) {
                return true;
            }
        }
        

        return false; // No se encontró un festivo que coincida con la fecha ingresada       
   }    
}
