package App.Clear.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "estado_animo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado_Animo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoAnimo;

    @Column(nullable = false)
    private String nombre; // Feliz, Triste, etc.

    @Column(nullable = true)
    private String icono; // nombre del recurso

    @Column(nullable = true)
    private String colorHex;

    @OneToMany(mappedBy = "estadoAnimo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("estadoAnimo-registroAnimo")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Registro_Animo> registros;
}
