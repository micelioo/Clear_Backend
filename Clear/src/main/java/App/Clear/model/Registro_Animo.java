package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "registro_animo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro_Animo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroAnimo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = true, length = 500)
    private String nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("estadoAnimo-registroAnimo")
    @JoinColumn(
            name = "id_estado_animo",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_registro_estadoAnimo")
    )
    private Estado_Animo estadoAnimo;

    @JsonProperty("estadoAnimoNombre")
    public String getEstadoAnimoNombre() {
        return (estadoAnimo != null) ? estadoAnimo.getNombre() : null;
    }
}
