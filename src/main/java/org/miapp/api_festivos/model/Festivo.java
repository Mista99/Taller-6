package org.miapp.api_festivos.model;

import jakarta.persistence.*;

@Access(AccessType.PROPERTY)
@Entity
@Table(name = "Festivo")
public class Festivo {

    private Long id;
    private String nombre;
    private int dia;
    private int mes;
    private int diasPascua;
    private Tipo tipo;

    public Festivo() {
        // Constructor vacío necesario para JPA
    }    

    // Coloca la anotación @Id sobre el getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Dia")
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Column(name = "Mes")
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Column(name = "DiasPascua")
    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    //relacion
    @ManyToOne
    @JoinColumn(name = "IdTipo", referencedColumnName = "Id")
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

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

