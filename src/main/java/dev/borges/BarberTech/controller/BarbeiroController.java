package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.BarbeiroResponseDTO;
import dev.borges.BarberTech.service.BarbeiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {


    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @PostMapping
    public ResponseEntity<BarbeiroResponseDTO> adicionarBarbeiro(@RequestBody BarbeiroRequestDTO novoBarbeiro){
        BarbeiroResponseDTO barbeiro = barbeiroService.adicionarBarbeiro(novoBarbeiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbeiro);
    }

}
