package org.miapp.api_festivos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Festivo\"")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")  // Nombre exacto de la columna en la base de datos
    private String nombre;

    @Column(name = "Dia")  // Nombre exacto de la columna en la base de datos
    private int dia;

    @Column(name = "Mes")  // Nombre exacto de la columna en la base de datos
    private int mes;

    @Column(name = "DiasPascua")  // Nombre exacto de la columna en la base de datos
    private int diasPascua;

    @ManyToOne
    @JoinColumn(name = "IdTipo")  // Especificar la columna de la clave foránea si es necesario
    private Tipo tipo;

    // Constructor con parámetros
    public Festivo(String nombre, int dia, int mes, int diasPascua, Tipo tipo) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
    }

    // Constructor vacío
    public Festivo() {
        // Constructor vacío por si es necesario crear un objeto vacío antes de la persistencia
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
