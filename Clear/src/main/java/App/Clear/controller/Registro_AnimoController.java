package App.Clear.controller;

import App.Clear.model.Registro_Animo;
import App.Clear.service.Registro_AnimoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registros-animo")
public class Registro_AnimoController {

    @Autowired
    private Registro_AnimoService registroAnimoService;

    @GetMapping
    public ResponseEntity<List<Registro_Animo>> listar() {
        List<Registro_Animo> registros = registroAnimoService.findAll();
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro_Animo> buscar(@PathVariable Long id) {
        Registro_Animo registro = registroAnimoService.findById(id);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @PostMapping
    public ResponseEntity<Registro_Animo> crear(@RequestBody Registro_Animo registro) {
        Registro_Animo nuevo = registroAnimoService.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro_Animo> actualizar(@PathVariable Long id, @RequestBody Registro_Animo datos) {
        Registro_Animo existente = registroAnimoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setFecha(datos.getFecha());
        existente.setNota(datos.getNota());
        existente.setEstadoAnimo(datos.getEstadoAnimo());

        Registro_Animo actualizado = registroAnimoService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Registro_Animo existente = registroAnimoService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        registroAnimoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
