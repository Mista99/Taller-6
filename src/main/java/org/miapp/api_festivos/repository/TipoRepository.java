package org.miapp.api_festivos.repository;

import org.miapp.api_festivos.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
}