package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.VendaRequestDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<VendaResponseDTO> registrarVenda(@RequestBody VendaRequestDTO requestDTO){
        VendaResponseDTO venda = vendaService.registrarVenda(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
