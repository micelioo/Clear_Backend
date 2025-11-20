package App.Clear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prioridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;

    @Column(nullable = false, length = 1)
    private String codigo;

    @Column(nullable = false)
    private String nombre; // ALTA, MEDIA, BAJA

    @Column(nullable = true)
    private String colorHex; // #FF0000

    @Column(nullable = false)
    private LocalDate fechaCreacion;
}
