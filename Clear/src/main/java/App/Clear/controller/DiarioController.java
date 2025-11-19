package App.Clear.controller;

import App.Clear.model.Diario;
import App.Clear.service.DiarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diarios")
public class DiarioController {

    @Autowired
    private DiarioService diarioService;

    @GetMapping
    public ResponseEntity<List<Diario>> listar() {
        List<Diario> diarios = diarioService.findAll();
        if (diarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(diarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diario> buscar(@PathVariable Long id) {
        Diario diario = diarioService.findById(id);
        if (diario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diario);
    }

    @PostMapping
    public ResponseEntity<Diario> crear(@RequestBody Diario diario) {
        Diario nuevo = diarioService.save(diario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diario> actualizar(@PathVariable Long id, @RequestBody Diario datos) {
        Diario existente = diarioService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setFecha(datos.getFecha());
        existente.setTitulo(datos.getTitulo());
        existente.setContenido(datos.getContenido());
        existente.setEstadoAnimo(datos.getEstadoAnimo());

        Diario actualizado = diarioService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Diario existente = diarioService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        diarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
