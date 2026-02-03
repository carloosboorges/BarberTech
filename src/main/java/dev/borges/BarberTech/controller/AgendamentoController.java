package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamento")
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
}
