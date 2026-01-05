package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.ClienteRequestDTO;
import dev.borges.BarberTech.dto.ClienteResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import dev.borges.BarberTech.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> adicionarCliente(@RequestBody ClienteRequestDTO novoCliente){
        ClienteResponseDTO cliente = clienteService.adicionarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente(){
        List<ClienteResponseDTO> lista = clienteService.listarClientes();

        if  (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> listarPorId(@PathVariable Long id){
        ClienteResponseDTO cliente = clienteService.listarPorId(id);
        return ResponseEntity.ok(cliente);
    }
}
