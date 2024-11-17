package org.miapp.api_festivos.repository;

import org.miapp.api_festivos.model.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository extends JpaRepository<Festivo, Long> {

    Optional<Festivo> findByDiaAndMes(int dia, int mes);
    List<Festivo> findByTipoIn(List<Integer> tipos);
}
