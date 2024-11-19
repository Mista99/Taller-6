package org.miapp.api_festivos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo")
@Access(AccessType.PROPERTY)
public class Tipo {

    private Long id;
    private String tipoName;
    private List<Festivo> festivos;

    // Constructor vacío necesario para JPA
    public Tipo() {
    }

    // Constructor con parámetros
    public Tipo(Long id, String tipoName) {
        this.id = id;
        this.tipoName = tipoName;
    }

    // Getters y setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Tipo")
    public String getTipoName() {
        return tipoName;
    }

    public void setTipoName(String tipoName) {
        this.tipoName = tipoName;
    }
    //relacion desde la talba Tipo
    @OneToMany(mappedBy = "tipo")
    public List<Festivo> getFestivos() {
        return festivos;
    }

    public void setFestivos(List<Festivo> festivos) {
        this.festivos = festivos;
    }

    @Override
    public String toString() {
        return "Tipo{" +
               "id=" + id +
               ", tipoName='" + tipoName + '\'' +
               '}';
    }

    // Implementación del método valueOf para devolver un Tipo basado en un entero
    public static Tipo valueOf(int i) {
        switch (i) {
            case 1: return new Tipo(null, "TIPO1");
            case 2: return new Tipo(null, "TIPO2");
            case 3: return new Tipo(null, "TIPO3");
            default: throw new IllegalArgumentException("Valor no válido: " + i);
        }
    }
}
