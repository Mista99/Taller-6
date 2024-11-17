package org.miapp.api_festivos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Este es el equivalente a "SERIAL" en PostgreSQL
    @Column(name = "Id", nullable = false)  // Especifica que esta columna no puede ser nula
    private Long id;

    @Column(name = "Tipo", nullable = false, length = 100)  // Especifica el nombre de la columna y su longitud
    private String tipo;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
