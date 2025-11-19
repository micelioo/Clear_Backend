package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "diario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiario;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference // opcional, solo si haces la relación inversa en Estado_Animo
    @JoinColumn(
            name = "id_estado_animo",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_diario_estadoAnimo")
    )
    private Estado_Animo estadoAnimo; // puede ser null
}
