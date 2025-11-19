package App.Clear.controller;

import App.Clear.model.Tarea;
import App.Clear.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    /** Lista todas las tareas */
    @GetMapping
    public ResponseEntity<List<Tarea>> listar() {
        List<Tarea> tareas = tareaService.findAll();
        if (tareas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tareas);
    }

    /** Obtiene una tarea por id */
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscar(@PathVariable Long id) {
        Tarea tarea = tareaService.findById(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    /** Crea una nueva tarea */
    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
        Tarea nueva = tareaService.save(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    /** Actualiza una tarea existente */
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody Tarea datos) {
        Tarea existente = tareaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setTitulo(datos.getTitulo());
        existente.setDescripcion(datos.getDescripcion());
        existente.setFechaLimite(datos.getFechaLimite());
        existente.setEstado(datos.getEstado());
        existente.setPrioridad(datos.getPrioridad());

        Tarea actualizada = tareaService.save(existente);
        return ResponseEntity.ok(actualizada);
    }

    /** Elimina una tarea por id */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Tarea existente = tareaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        tareaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
