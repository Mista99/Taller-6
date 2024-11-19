package org.miapp.api_festivos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tipo")
@Access(AccessType.FIELD)
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Hibernate elegirá la estrategia adecuada según la base de datos
    private Long id;

    @Column(name = "Tipo")
    private String tipoName;

    @OneToMany(mappedBy = "tipo")  // Relación con la clase Festivo, mapeando el campo 'tipo' en la clase Festivo
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoName() {
        return tipoName;
    }

    public void setTipoName(String tipoName) {
        this.tipoName = tipoName;
    }

    public List<Festivo> getFestivos() {
        return festivos;
    }

    public void setFestivos(List<Festivo> festivos) {
        this.festivos = festivos;
    }

    // Método toString para obtener una representación legible del objeto
    @Override
    public String toString() {
        return "Tipo{" +
               "id=" + id +
               ", tipo='" + tipoName + '\'' +
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
