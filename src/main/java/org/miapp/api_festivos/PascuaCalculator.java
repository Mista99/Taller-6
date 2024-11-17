package org.miapp.api_festivos;

import java.time.LocalDate;

public class PascuaCalculator {

    public static LocalDate calcularPascua(int anio) {
        // Cálculo de a, b, c, d y los días después del 15 de marzo
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;

        // El número de días después del 15 de marzo para el Domingo de Pascua
        int dias = d + e;

        // Si el valor 'dias' es negativo, ajustamos para que sea positivo
        if (dias < 0) {
            dias += 30;
        }

        // El Domingo de Pascua será 15 de marzo + días calculados
        LocalDate pascua = LocalDate.of(anio, 3, 15).plusDays(dias + 7); // +7 para el Domingo de Pascua

        // Devolver la fecha del Domingo de Pascua
        return pascua;
    }
}
