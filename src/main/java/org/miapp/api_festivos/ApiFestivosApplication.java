package org.miapp.api_festivos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFestivosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiFestivosApplication.class, args);
        // Se puede invocar la clase CalculoPascua aquí si deseas probarla
        for (int anio = 2024; anio <= 2028; anio++) {
            CalculoPascua.calcularPascua(anio);
        }
    }
}

// Clase separada para el cálculo de Pascua
class CalculoPascua {

    public static void calcularPascua(int anio) {
        // Cálculo de a, b, c, d
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;

        // Cálculo de los días después del 15 de marzo
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        // Calcular el Domingo de Ramos (15 de marzo + días)
        int diaDomingoRamos = 15 + dias;
        int mesDomingoRamos = 3; // Marzo es el mes 3

        // Ajuste si el Domingo de Ramos se pasa a abril
        if (diaDomingoRamos > 31) {
            diaDomingoRamos -= 31; // Ajustar para abril
            mesDomingoRamos = 4; // Abril es el mes 4
        }

        // El Domingo de Pascua es una semana después del Domingo de Ramos
        int diaPascua = diaDomingoRamos + 7;
        int mesPascua = mesDomingoRamos;

        // Ajuste si el Domingo de Pascua se pasa de marzo a abril
        if (mesDomingoRamos == 3 && diaPascua > 31) {
            diaPascua -= 31;
            mesPascua = 4;
        }

        // Mostrar resultados
        System.out.println("Pascua en " + anio + ": " + diaPascua + " de " + (mesPascua == 3 ? "marzo" : "abril"));
    }
}
