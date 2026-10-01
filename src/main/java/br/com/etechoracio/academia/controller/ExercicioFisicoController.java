package br.com.etechoracio.academia.controller;
import br.com.etechoracio.academia.DTO.ExercicioFisicoResponseDTO; 
import br.com.etechoracio.academia.service.ExercicioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/exercicios-fisicos")
public class ExercicioFisicoController {

    @Autowired
    private ExercicioFisicoService service;

    @GetMapping
    public List<ExercicioFisicoResponseDTO> listarAprovados() {
        return service.listarAprovados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioFisicoResponseDTO> buscarPorId(@PathVariable Long id) {
        ExercicioFisicoResponseDTO dto = service.buscarPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(dto);
    }
}