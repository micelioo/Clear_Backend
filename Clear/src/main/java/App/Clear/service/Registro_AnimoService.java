package App.Clear.service;

import App.Clear.model.Registro_Animo;
import App.Clear.repository.Registro_AnimoRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class Registro_AnimoService {

    @Autowired
    private Registro_AnimoRepository registroAnimoRepository;

    public List<Registro_Animo> findAll() {
        return registroAnimoRepository.findAll();
    }

    public Registro_Animo findById(Long id) {
        return registroAnimoRepository.findById(id).orElse(null);
    }

    public Registro_Animo save(Registro_Animo registroAnimo) {
        return registroAnimoRepository.save(registroAnimo);
    }

    public void delete(Long id) {
        registroAnimoRepository.deleteById(id);
    }
}
