package org.miapp.api_festivos.controller;

import org.miapp.api_festivos.model.Festivo;
import org.miapp.api_festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    @Autowired
    private FestivoService festivoService;

    @GetMapping("/validar/{dia}/{mes}")
    public ResponseEntity<String> validarFecha(@PathVariable int dia, @PathVariable int mes) {
        boolean esFestivo = festivoService.esFestivo(dia, mes);
        if (esFestivo) {
            Optional<Festivo> festivo = festivoService.obtenerFestivo(dia, mes);
            return ResponseEntity.ok("La fecha " + dia + "/" + mes + " es festiva: " + festivo.get().getNombre());
        } else {
            return ResponseEntity.ok("La fecha " + dia + "/" + mes + " no es festiva.");
        }
    }
}
