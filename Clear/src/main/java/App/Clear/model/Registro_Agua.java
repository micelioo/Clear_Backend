package App.Clear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "registro_agua")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro_Agua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroAgua;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Integer cantidadMl;
}

