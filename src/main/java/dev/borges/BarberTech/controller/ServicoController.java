package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ServicoRequestDTO;
import dev.borges.BarberTech.dto.response.ServicoResponseDTO;
import dev.borges.BarberTech.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> adicionarServico(@RequestBody ServicoRequestDTO servicoRequestDTO) {
        ServicoResponseDTO servico = servicoService.adicionarServico(servicoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listarServicos() {
        List<ServicoResponseDTO> lista = servicoService.listarServicos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> listarPorId(@PathVariable Long id){
        ServicoResponseDTO servico = servicoService.listarPorId(id);

        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@PathVariable Long id, @RequestBody ServicoRequestDTO request){
        ServicoResponseDTO servico = servicoService.atualizarServico(id, request);

        return ResponseEntity.ok(servico);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }


}


