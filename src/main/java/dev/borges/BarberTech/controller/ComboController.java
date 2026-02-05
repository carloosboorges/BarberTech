package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.enums.StatusCombo;
import dev.borges.BarberTech.repository.ComboRepository;
import dev.borges.BarberTech.service.ComboService;
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
@RequestMapping("/combo")
@Tag(name = "Combos", description = "Operações relacionadas á combos")
public class ComboController {

    private final ComboService comboService;

    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @Operation(
            summary = "Registra um novo combo ",
            description = "Cadastra um novo combo no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Combo registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo combo"),
    })
    @PostMapping()
    public ResponseEntity<ComboResponseDTO> criarCombo(@RequestBody @Valid ComboRequestDTO request) {
        ComboResponseDTO combo = comboService.criarCombo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(combo);
    }

    @Operation(summary = "Lista todos os combos")
    @GetMapping()
    public ResponseEntity<List<ComboResponseDTO>> listarCombos(){
        List<ComboResponseDTO> combos = comboService.listarCombos();

        if(combos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(combos);
    }

    @Operation(summary = "Lista um combo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ComboResponseDTO> buscarPorId(@PathVariable Long id){
        ComboResponseDTO combo = comboService.listarPorId(id);
        return ResponseEntity.ok(combo);
    }

    @Operation(summary = "Lista um combo por status")
    @GetMapping("status/{status}")
    public ResponseEntity<List<ComboResponseDTO>> buscarPorStatus(@PathVariable String status){
        return ResponseEntity.ok(comboService.buscarPorStatus(StatusCombo.from(status)));
    }

    @Operation(
            summary = "Atualiza um combo ",
            description = "Atualiza um combo no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Combo registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo combo"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ComboResponseDTO> atualizarCombo(@PathVariable Long id, @RequestBody @Valid ComboRequestDTO request){
        ComboResponseDTO combo = comboService.atualizarCombo(id, request);

        return ResponseEntity.ok(combo);
    }

    @Operation(summary = "Inativa um combo do sistema", description = "Altera o status do combo para INATIVO")
    @PutMapping("/{id}/inativar")
    public ResponseEntity<ComboResponseDTO> inativarCombo(@PathVariable Long id) {
        return ResponseEntity.ok(comboService.inativarCombo(id));
    }

    @Operation(summary = "Ativa um combo do sistema", description = "Altera o status do combo para ATIVO")
    @PutMapping("/{id}/ativar")
    public ResponseEntity<ComboResponseDTO> ativarCombo(@PathVariable Long id) {
        return ResponseEntity.ok(comboService.ativarCombo(id));
    }



}
