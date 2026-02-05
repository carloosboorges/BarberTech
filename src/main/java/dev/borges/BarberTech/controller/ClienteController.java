package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.request.ClienteRequestDTO;
import dev.borges.BarberTech.dto.response.ClienteResponseDTO;
import dev.borges.BarberTech.service.ClienteService;
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
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas á clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Registra um novo barbeiro ",
            description = "Adiciona um novo barbeiro"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Barbeiro registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo barbeiro"),
    })
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> adicionarCliente(@RequestBody @Valid ClienteRequestDTO novoCliente){
        ClienteResponseDTO cliente = clienteService.adicionarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @Operation(summary = "Lista todos os clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente(){
        List<ClienteResponseDTO> lista = clienteService.listarClientes();

        if  (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Lista um cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> listarPorId(@PathVariable Long id){
        ClienteResponseDTO cliente = clienteService.listarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(
            summary = "Registra um novo barbeiro ",
            description = "Adiciona um novo barbeiro"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Barbeiro registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo cliente"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> alterarCliente(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO request){
        ClienteResponseDTO cliente = clienteService.alterarCliente(id, request);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Deleta um cliente", description = "Deleta um cliente do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
