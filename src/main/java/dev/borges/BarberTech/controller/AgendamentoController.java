package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.enums.StatusAgendamento;
import dev.borges.BarberTech.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }


    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamneto(@RequestBody @Valid AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.criarAgendamento(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAll(){
        List<AgendamentoResponseDTO> agendamentos = agendamentoService.listarAgendamentos();

        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AgendamentoResponseDTO>> listarPorStatus(@PathVariable String status){
        return ResponseEntity.ok(agendamentoService.listarPorStatus(StatusAgendamento.from(status)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> atualizarAgendamento(@PathVariable Long id, @RequestBody @Valid AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.atualizarAgendamento(id, request);

        return ResponseEntity.ok(agendamento);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<AgendamentoResponseDTO> cancelarAgendamento(@PathVariable Long id){

        return ResponseEntity.ok(agendamentoService.cancelarAgendamento(id));
    }

    @PutMapping("/{id}/realizar")
    public ResponseEntity<AgendamentoResponseDTO> realizarAgendamento(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoService.marcarComoRealizdo(id));
    }

}
