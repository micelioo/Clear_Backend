package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prioridad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad; // PK

    @Column(nullable = false, length = 1)
    private String codigo; // por ejemplo 'A', 'B', 'C'

    @Column(nullable = false)
    private String nombre; // Alta, Media, Baja

    @Column(nullable = true)
    private String colorHex; // #FF0000

    @Column(nullable = false)
    private LocalDate fechaCreacion; // para cumplir Date

    @OneToMany(mappedBy = "prioridad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("prioridad-tarea")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Tarea> tareas; // tareas asociadas

    @JsonProperty("descripcionCompleta")
    public String getDescripcionCompleta() {
        return nombre + " (" + codigo + ")"; // ej: "Alta (A)"
    }
}
