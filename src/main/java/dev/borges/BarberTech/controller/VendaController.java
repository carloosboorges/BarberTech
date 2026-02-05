package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.request.VendaRequestDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.enums.StatusVenda;
import dev.borges.BarberTech.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Vendas", description = "Operações relacionadas ás vendas")
@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Operation(
            summary = "Registra uma nova venda ",
            description = "Cadastra uma nova venda para o cliente no sistema."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Venda registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar venda"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @PostMapping
    public ResponseEntity<VendaResponseDTO> registrarVenda(@Valid @RequestBody VendaRequestDTO requestDTO){
        VendaResponseDTO venda = vendaService.registrarVenda(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }

    @Operation(summary = "Lista todas as vendas")
    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> listarTodas(){
        List<VendaResponseDTO> vendas = vendaService.listarTodas();

        if(vendas.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(vendas);
    }
    @Operation(summary = "Busca uma venda por ID")
    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> listarPorId(@PathVariable Long id){
        VendaResponseDTO venda = vendaService.listarPorId(id);

        return ResponseEntity.ok(venda);
    }

    @Operation(summary = "Lista as compras de um cliente.")
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<VendaResponseDTO>> listarVendaPorCliente(@PathVariable Long clienteId){
        List<VendaResponseDTO> lista = vendaService.listarVendaPorCliente(clienteId);

        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
    @Operation(summary = "Lista as vendas por data")
    @GetMapping("/data")
    public ResponseEntity<List<VendaResponseDTO>> listarPorData(@RequestParam LocalDate data){
        List<VendaResponseDTO> vendas = vendaService.listarVendaPorData(data);
        return ResponseEntity.ok(vendas);
    }

    @Operation(summary = "Cancela uma venda")
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<VendaResponseDTO> cancelarVenda(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.cancelarVenda(id));
    }

    @Operation(summary = "Finaliza uma venda")
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<VendaResponseDTO> marcarComoFinalizado(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.marcarComoFinalizada(id));
    }

    @Operation(summary = "Lista vendas por status")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<VendaResponseDTO>> listarVendaPorStatus(@PathVariable String status){
        return ResponseEntity.ok(vendaService.listarPorStatus(StatusVenda.from(status)));
    }
}
