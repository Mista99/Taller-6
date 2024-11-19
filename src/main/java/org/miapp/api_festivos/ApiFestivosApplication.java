package org.miapp.api_festivos;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.service.FestivoService;

@SpringBootApplication
public class ApiFestivosApplication {

    // Inyección de dependencias para usar el servicio
    @Autowired
    private FestivoService festivoService;

    public static void main(String[] args) {
        SpringApplication.run(ApiFestivosApplication.class, args);
    }

    @PostConstruct
    public void init() {
        //probar llamadas y verificar en consola
        List<Festivo> festivos1 = festivoService.obtenerFestivosTipo1();  // Obtener los festivos de tipo 1 (constantes durante el año)
        List<Festivo> festivos2 = festivoService.obtenerFestivosTipo2();  
        List<Festivo> festivos3 = festivoService.obtenerFestivosTipo3();
        List<Festivo> festivos4 = festivoService.obtenerFestivosTipo4();

        System.out.println("-------------------------prueba festivos tipo 1-------------------------");
        for (Festivo festivo : festivos1) {
            System.out.println(festivo.toString());
        }
        System.out.println("-------------------------prueba festivos tipo 2-------------------------");
        for (Festivo festivo : festivos2) {
            System.out.println(festivo.toString());
        }
        System.out.println("-------------------------prueba festivos tipo 3-------------------------");
        for (Festivo festivo : festivos3) {
            System.out.println(festivo.toString());
        }
        System.out.println("-------------------------prueba festivos tipo 4-------------------------");
        for (Festivo festivo : festivos4) {
            System.out.println(festivo.toString());
        }
        

    }

}
