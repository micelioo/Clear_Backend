package App.Clear.controller;

import App.Clear.model.Prioridad;
import App.Clear.service.PrioridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prioridades")
public class PrioridadController {

    @Autowired
    private PrioridadService prioridadService;

    @GetMapping
    public ResponseEntity<List<Prioridad>> listar() {
        List<Prioridad> prioridades = prioridadService.findAll();
        if (prioridades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prioridades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> buscar(@PathVariable Long id) {
        Prioridad prioridad = prioridadService.findById(id);
        if (prioridad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prioridad);
    }

    @PostMapping
    public ResponseEntity<Prioridad> crear(@RequestBody Prioridad prioridad) {
        Prioridad nueva = prioridadService.save(prioridad);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> actualizar(@PathVariable Long id, @RequestBody Prioridad datos) {
        Prioridad existente = prioridadService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setCodigo(datos.getCodigo());
        existente.setNombre(datos.getNombre());
        existente.setColorHex(datos.getColorHex());
        existente.setFechaCreacion(datos.getFechaCreacion());

        Prioridad actualizada = prioridadService.save(existente);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Prioridad existente = prioridadService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        prioridadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
