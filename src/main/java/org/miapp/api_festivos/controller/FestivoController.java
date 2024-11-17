package org.miapp.api_festivos.controller;

import org.miapp.api_festivos.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FestivoController {

    @Autowired
    private FestivoService festivoService;

    @GetMapping("/validar/{anio}/{mes}/{dia}")
    public String validarFecha(@PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        boolean esFestivo = festivoService.esFestivo(anio, mes, dia);
        return esFestivo ? "Es festivo" : "No es festivo";
    }
}
