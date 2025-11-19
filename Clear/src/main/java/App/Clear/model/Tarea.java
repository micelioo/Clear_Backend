package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tarea")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = true, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Column(nullable = false, length = 1)
    private String estado; // P = pendiente, C = completada

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("prioridad-tarea")
    @JoinColumn(
            name = "id_prioridad",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tarea_prioridad")
    )
    private Prioridad prioridad;

    @JsonProperty("prioridadNombre")
    public String getPrioridadNombre() {
        return (prioridad != null) ? prioridad.getNombre() : null;
    }
}
