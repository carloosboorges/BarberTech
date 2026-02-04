package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.response.BarbeiroResponseDTO;
import dev.borges.BarberTech.service.BarbeiroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {


    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @PostMapping
    public ResponseEntity<BarbeiroResponseDTO> adicionarBarbeiro(@RequestBody @Valid BarbeiroRequestDTO novoBarbeiro) {
        BarbeiroResponseDTO barbeiro = barbeiroService.adicionarBarbeiro(novoBarbeiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbeiro);
    }

    @GetMapping
    public ResponseEntity<List<BarbeiroResponseDTO>> listarAll() {
        List<BarbeiroResponseDTO> lista = barbeiroService.listarBarbeiro();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeiroResponseDTO> ListarPorId(@PathVariable Long id) {
        BarbeiroResponseDTO barbeiro = barbeiroService.listarPorId(id);

        return ResponseEntity.ok(barbeiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarbeiroResponseDTO> atualizarBarbeiro(@PathVariable Long id, @RequestBody @Valid BarbeiroRequestDTO request) {
        BarbeiroResponseDTO update = barbeiroService.atualizarBarbeiro(id, request);

        return ResponseEntity.ok(update);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBarbeiro(@PathVariable Long id) {
        barbeiroService.deletarBarbeiro(id);
        return ResponseEntity.noContent().build();
    }

}
