package App.Clear.controller;

import App.Clear.model.Estado_Animo;
import App.Clear.service.Estado_AnimoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estados-animo")
public class Estado_AnimoController {

    @Autowired
    private Estado_AnimoService estadoAnimoService;

    @GetMapping
    public ResponseEntity<List<Estado_Animo>> listar() {
        List<Estado_Animo> estados = estadoAnimoService.findAll();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado_Animo> buscar(@PathVariable Long id) {
        Estado_Animo estado = estadoAnimoService.findById(id);
        if (estado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping
    public ResponseEntity<Estado_Animo> crear(@RequestBody Estado_Animo estado) {
        Estado_Animo nuevo = estadoAnimoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado_Animo> actualizar(@PathVariable Long id, @RequestBody Estado_Animo datos) {
        Estado_Animo existente = estadoAnimoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombre(datos.getNombre());
        existente.setIcono(datos.getIcono());
        existente.setColorHex(datos.getColorHex());

        Estado_Animo actualizado = estadoAnimoService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Estado_Animo existente = estadoAnimoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        estadoAnimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
