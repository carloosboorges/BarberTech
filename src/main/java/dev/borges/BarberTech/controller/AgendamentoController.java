package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.service.AgendamentoService;
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
    public ResponseEntity<AgendamentoResponseDTO> criarAgendamneto(@RequestBody AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.criarAgendamento(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponseDTO>> listarAll(){
        List<AgendamentoResponseDTO> agendamentos = agendamentoService.listarAgendamentos();

        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping()
    public ResponseEntity<AgendamentoResponseDTO> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoRequestDTO request){
        AgendamentoResponseDTO agendamento = agendamentoService.atualizarAgendamento(id, request);

        return ResponseEntity.ok(agendamento);
    }

}
