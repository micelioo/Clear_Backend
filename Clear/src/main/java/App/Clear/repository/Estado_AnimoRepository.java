package App.Clear.repository;

import App.Clear.model.Estado_Animo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estado_AnimoRepository extends JpaRepository<Estado_Animo, Long> {
}
