package App.Clear.controller;

import App.Clear.model.Registro_Agua;
import App.Clear.service.Registro_AguaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registros-agua")
public class Registro_AguaController {

    @Autowired
    private Registro_AguaService registroAguaService;

    @GetMapping
    public ResponseEntity<List<Registro_Agua>> listar() {
        List<Registro_Agua> registros = registroAguaService.findAll();
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro_Agua> buscar(@PathVariable Long id) {
        Registro_Agua registro = registroAguaService.findById(id);
        if (registro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @PostMapping
    public ResponseEntity<Registro_Agua> crear(@RequestBody Registro_Agua registro) {
        Registro_Agua nuevo = registroAguaService.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro_Agua> actualizar(@PathVariable Long id, @RequestBody Registro_Agua datos) {
        Registro_Agua existente = registroAguaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setFecha(datos.getFecha());
        existente.setCantidadMl(datos.getCantidadMl());

        Registro_Agua actualizado = registroAguaService.save(existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Registro_Agua existente = registroAguaService.findById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        registroAguaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
