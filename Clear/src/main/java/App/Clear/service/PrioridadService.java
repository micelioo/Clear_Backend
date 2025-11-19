package App.Clear.service;

import App.Clear.model.Prioridad;
import App.Clear.repository.PrioridadRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PrioridadService {

    @Autowired
    private PrioridadRepository prioridadRepository;

    public List<Prioridad> findAll() {
        return prioridadRepository.findAll();
    }

    public Prioridad findById(Long id) {
        return prioridadRepository.findById(id).orElse(null);
    }

    public Prioridad save(Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    public void delete(Long id) {
        prioridadRepository.deleteById(id);
    }
}
