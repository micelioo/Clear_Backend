package App.Clear.service;

import App.Clear.model.Estado_Animo;
import App.Clear.repository.Estado_AnimoRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class Estado_AnimoService {

    @Autowired
    private Estado_AnimoRepository estadoAnimoRepository;

    public List<Estado_Animo> findAll() {
        return estadoAnimoRepository.findAll();
    }

    public Estado_Animo findById(Long id) {
        return estadoAnimoRepository.findById(id).orElse(null);
    }

    public Estado_Animo save(Estado_Animo estadoAnimo) {
        return estadoAnimoRepository.save(estadoAnimo);
    }

    public void delete(Long id) {
        estadoAnimoRepository.deleteById(id);
    }
}
