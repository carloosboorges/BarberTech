package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ServicoRequestDTO;
import dev.borges.BarberTech.dto.response.ServicoResponseDTO;
import dev.borges.BarberTech.service.ServicoService;
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
@RequestMapping("/servicos")
@Tag(name = "Serviços", description = "Operações relacionadas á serviços")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @Operation(
            summary = "Registra um novo serviço ",
            description = "Cadastra um novo serviço no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Serviço registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo serviço"),
    })
    @PostMapping
    public ResponseEntity<ServicoResponseDTO> adicionarServico(@RequestBody @Valid ServicoRequestDTO servicoRequestDTO) {
        ServicoResponseDTO servico = servicoService.adicionarServico(servicoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    @Operation(summary = "Lista todos serviços do sistema")
    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listarServicos() {
        List<ServicoResponseDTO> lista = servicoService.listarServicos();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Lista um serviço do sistema por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> listarPorId(@PathVariable Long id){
        ServicoResponseDTO servico = servicoService.listarPorId(id);

        return ResponseEntity.ok(servico);
    }

    @Operation(
            summary = "Atualiza um serviço ",
            description = "Atualiza um serviço no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Serviço atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualizar um serviço"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado no sistema"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@PathVariable Long id, @RequestBody @Valid ServicoRequestDTO request){
        ServicoResponseDTO servico = servicoService.atualizarServico(id, request);

        return ResponseEntity.ok(servico);

    }

    @Operation(summary = "Deleta um serviço do sistema por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }


}


