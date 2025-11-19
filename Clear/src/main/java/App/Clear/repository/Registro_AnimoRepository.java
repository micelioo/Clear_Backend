package App.Clear.repository;

import App.Clear.model.Registro_Animo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro_AnimoRepository extends JpaRepository<Registro_Animo, Long> {
}
