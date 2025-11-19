package App.Clear.service;

import App.Clear.model.Tarea;
import App.Clear.repository.TareaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea findById(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void delete(Long id) {
        tareaRepository.deleteById(id);
    }
}
