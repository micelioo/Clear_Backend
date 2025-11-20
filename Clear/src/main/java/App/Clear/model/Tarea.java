package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonProperty("id")                      // JSON: id
    private Long idTarea;

    @Column(nullable = false)
    @JsonProperty("title")                   // JSON: title
    private String titulo;

    @Column(nullable = false)
    @JsonProperty("dueDate")                 // JSON: dueDate
    private LocalDate fechaLimite;

    @Column(nullable = false)
    @JsonProperty("done")                    // JSON: done
    private Boolean done = false;

    @Column(nullable = true, length = 500)
    private String descripcion;              // el front la puede ignorar

    // FK a PRIORIDAD: se usa a nivel de BD, no hace falta que el front reciba el objeto completo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_prioridad",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tarea_prioridad")
    )
    @JsonBackReference("prioridad-tarea")
    @JsonIgnore
    private Prioridad prioridad;

    // Esto es lo que verá Android como "prioridad" para mapear al enum { ALTA, MEDIA, BAJA }
    @JsonProperty("prioridad")
    public String getPrioridadEnum() {
        if (prioridad == null || prioridad.getNombre() == null) return null;
        return prioridad.getNombre().toUpperCase();   // ALTA, MEDIA, BAJA
    }
}
