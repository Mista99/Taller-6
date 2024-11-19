package org.miapp.api_festivos.service;
import org.miapp.api_festivos.model.Tipo;
import org.miapp.api_festivos.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public Tipo obtenerTipoPorId(long id) {
        return tipoRepository.findById(id);  // Recupera el objeto Tipo por su id
    }
}
