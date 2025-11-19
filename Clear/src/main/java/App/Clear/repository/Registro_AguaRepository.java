package App.Clear.repository;

import App.Clear.model.Registro_Agua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Registro_AguaRepository extends JpaRepository<Registro_Agua, Long> {
}
