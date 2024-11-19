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
        // Llamada al servicio para obtener los festivos de tipo 3
        List<Festivo> festivos = festivoService.obtenerFestivosTipo3();
        // Imprimir cada festivo de la lista usando el método toString()
        System.out.println("-------------------------prueba-------------------------");
        for (Festivo festivo : festivos) {
            System.out.println(festivo.toString());
        }
    }

}
