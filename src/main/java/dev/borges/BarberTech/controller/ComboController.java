package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.service.ComboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
public class ComboController {

    private final ComboService comboService;

    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @PostMapping()
    public ResponseEntity<ComboResponseDTO> criarCombo(@RequestBody ComboRequestDTO request) {
        ComboResponseDTO combo = comboService.criarCombo(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(combo);

    }
}
