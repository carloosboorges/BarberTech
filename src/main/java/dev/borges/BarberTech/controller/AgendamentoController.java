package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.enums.StatusAgendamento;
import dev.borges.BarberTech.service.AgendamentoService;
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
@RequestMapping("/agendamentos")
@Tag(name = "Agendamento", description = "Operações relacionadas á Agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }


    @Operation(
            summary = "Registra um novo agendamento ",
            description = "Cadastra um novo agendamento no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Barbeiro registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo barbeiro"),
    })
    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamneto(@RequestBody @Valid AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.criarAgendamento(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }

    @Operation(summary = "Lista todos agendamento do sistema")
    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAll(){
        List<AgendamentoResponseDTO> agendamentos = agendamentoService.listarAgendamentos();

        return ResponseEntity.ok(agendamentos);
    }

    @Operation(summary = "Lista todos os agendamento do sistema por status")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarPorStatus(@PathVariable String status){
        return ResponseEntity.ok(agendamentoService.listarPorStatus(StatusAgendamento.from(status)));
    }

    @Operation(
            summary = "Atualiza um agendamento ",
            description = "Atualiza um agendamento no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agendamento atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualizar um agendamento"),
            @ApiResponse(responseCode = "404", description = "Agendamento não encontrado no sistema"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizarAgendamento(@PathVariable Long id, @RequestBody @Valid AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.atualizarAgendamento(id, request);

        return ResponseEntity.ok(agendamento);
    }

    @Operation(summary = "Cancela um agendamento por ID")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<AgendamentoResponseDTO> cancelarAgendamento(@PathVariable Long id){

        return ResponseEntity.ok(agendamentoService.cancelarAgendamento(id));
    }

    @Operation(summary = "Marca um agendamento como realizado")
    @PutMapping("/{id}/realizar")
    public ResponseEntity<AgendamentoResponseDTO> realizarAgendamento(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoService.marcarComoRealizdo(id));
    }

}
