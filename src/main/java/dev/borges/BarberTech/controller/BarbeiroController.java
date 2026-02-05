package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.response.BarbeiroResponseDTO;
import dev.borges.BarberTech.service.BarbeiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/barbeiros")
@Tag(name = "Barbeiros", description = "Operações relacionadas á barbeiros")
public class BarbeiroController {


    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @Operation(
            summary = "Registra um novo barbeiro ",
            description = "Cadastra um novo barbeiro no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Barbeiro registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo barbeiro"),
    })
    @PostMapping
    public ResponseEntity<BarbeiroResponseDTO> adicionarBarbeiro(@RequestBody @Valid BarbeiroRequestDTO novoBarbeiro) {
        BarbeiroResponseDTO barbeiro = barbeiroService.adicionarBarbeiro(novoBarbeiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbeiro);
    }

    @Operation(summary = "Lista todos os barbeiros")
    @GetMapping
    public ResponseEntity<List<BarbeiroResponseDTO>> listarAll() {
        List<BarbeiroResponseDTO> lista = barbeiroService.listarBarbeiro();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(lista);
    }

    @Operation(summary = "Lista um barbeiro pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<BarbeiroResponseDTO> ListarPorId(@PathVariable Long id) {
        BarbeiroResponseDTO barbeiro = barbeiroService.listarPorId(id);

        return ResponseEntity.ok(barbeiro);
    }

    @Operation(
            summary = "Atualiza o barbeiro ",
            description = "Atualiza dados do barbeiro no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Barbeiro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualizar o barbeiro"),
            @ApiResponse(responseCode = "404", description = "Barbeiro não encontrado"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<BarbeiroResponseDTO> atualizarBarbeiro(@PathVariable Long id, @RequestBody @Valid BarbeiroRequestDTO request) {
        BarbeiroResponseDTO update = barbeiroService.atualizarBarbeiro(id, request);

        return ResponseEntity.ok(update);

    }

    @Operation(summary = "Deleta um barbeiro", description = "Deleta um barbeiro do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBarbeiro(@PathVariable Long id) {
        barbeiroService.deletarBarbeiro(id);
        return ResponseEntity.noContent().build();
    }

}
