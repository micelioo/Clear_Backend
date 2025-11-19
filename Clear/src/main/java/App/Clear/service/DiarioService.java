package App.Clear.service;

import App.Clear.model.Diario;
import App.Clear.repository.DiarioRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;

    public List<Diario> findAll() {
        return diarioRepository.findAll();
    }

    public Diario findById(Long id) {
        return diarioRepository.findById(id).orElse(null);
    }

    public Diario save(Diario diario) {
        return diarioRepository.save(diario);
    }

    public void delete(Long id) {
        diarioRepository.deleteById(id);
    }
}
