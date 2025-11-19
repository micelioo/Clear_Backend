package App.Clear.service;

import App.Clear.model.Registro_Agua;
import App.Clear.repository.Registro_AguaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class Registro_AguaService {

    @Autowired
    private Registro_AguaRepository registroAguaRepository;

    public List<Registro_Agua> findAll() {
        return registroAguaRepository.findAll();
    }

    public Registro_Agua findById(Long id) {
        return registroAguaRepository.findById(id).orElse(null);
    }

    public Registro_Agua save(Registro_Agua registroAgua) {
        return registroAguaRepository.save(registroAgua);
    }

    public void delete(Long id) {
        registroAguaRepository.deleteById(id);
    }
}
