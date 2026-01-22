package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.VendaRequestDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.repository.VendaRepository;
import dev.borges.BarberTech.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;
    private final VendaRepository vendaRepository;

    public VendaController(VendaService vendaService, VendaRepository vendaRepository) {
        this.vendaService = vendaService;
        this.vendaRepository = vendaRepository;
    }

    @PostMapping
    public ResponseEntity<VendaResponseDTO> registrarVenda(@RequestBody VendaRequestDTO requestDTO){
        VendaResponseDTO venda = vendaService.registrarVenda(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> listarTodas(){
        List<VendaResponseDTO> vendas = vendaService.listarTodas();

        if(vendas.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> listarPorId(@PathVariable Long id){
        VendaResponseDTO venda = vendaService.listarPorId(id);

        return ResponseEntity.ok(venda);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<VendaResponseDTO>> listarVendaPorCliente(@PathVariable Long clienteId){
        List<VendaResponseDTO> lista = vendaService.listarVendaPorCliente(clienteId);

        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/data")
    public ResponseEntity<List<VendaResponseDTO>> listarPorData(@RequestParam LocalDate data){
        List<VendaResponseDTO> vendas = vendaService.listarVendaPorData(data);
        return ResponseEntity.ok(vendas);
    }
}
