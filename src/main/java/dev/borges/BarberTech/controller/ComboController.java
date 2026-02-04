package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.enums.StatusCombo;
import dev.borges.BarberTech.repository.ComboRepository;
import dev.borges.BarberTech.service.ComboService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combo")
public class ComboController {

    private final ComboService comboService;

    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @PostMapping()
    public ResponseEntity<ComboResponseDTO> criarCombo(@RequestBody @Valid ComboRequestDTO request) {
        ComboResponseDTO combo = comboService.criarCombo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(combo);
    }

    @GetMapping()
    public ResponseEntity<List<ComboResponseDTO>> listarCombos(){
        List<ComboResponseDTO> combos = comboService.listarCombos();

        if(combos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(combos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComboResponseDTO> buscarPorId(@PathVariable Long id){
        ComboResponseDTO combo = comboService.listarPorId(id);
        return ResponseEntity.ok(combo);
    }

    @GetMapping("status/{status}")
    public ResponseEntity<List<ComboResponseDTO>> buscarPorStatus(@PathVariable String status){
        return ResponseEntity.ok(comboService.buscarPorStatus(StatusCombo.from(status)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComboResponseDTO> atualizarCombo(@PathVariable Long id, @RequestBody @Valid ComboRequestDTO request){
        ComboResponseDTO combo = comboService.atualizarCombo(id, request);

        return ResponseEntity.ok(combo);
    }

    @PutMapping("/{id}/inativar")
    public ResponseEntity<ComboResponseDTO> inativarCombo(@PathVariable Long id) {
        return ResponseEntity.ok(comboService.inativarCombo(id));
    }



}
