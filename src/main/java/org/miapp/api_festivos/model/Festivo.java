package org.miapp.api_festivos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Festivo")  // Mantener el nombre de la tabla en la base de datos
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Dia")
    private int dia;

    @Column(name = "Mes")
    private int mes;

    @Column(name = "dias_pascua")
    private int diasPascua;

    @ManyToOne
    @JoinColumn(name = "Id_tipo", referencedColumnName = "Id")
    private Tipo tipo;  // en lugar de id_tipo


    // Constructor sin parámetros para JPA
    public Festivo() {
        
    }

    // Constructor con parámetros
    public Festivo(String nombre, int dia, int mes, int diasPascua, Tipo tipo) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
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

    // Método toString para obtener una representación legible del objeto
    @Override
    public String toString() {
        return "Festivo{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", dia=" + dia +
               ", mes=" + mes +
               ", diasPascua=" + diasPascua +
               ", tipo=" + tipo +
               '}';
    }
}
