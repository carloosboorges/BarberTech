package dev.borges.BarberTech.controller;
import dev.borges.BarberTech.dto.request.ProdutoRequestDTO;
import dev.borges.BarberTech.dto.response.ProdutoResponseDTO;
import dev.borges.BarberTech.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> adicionarProduto(@RequestBody ProdutoRequestDTO request){
        ProdutoResponseDTO produto = produtoService.adicionarProtudo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos(){
        List<ProdutoResponseDTO> produto =  produtoService.listarProdutos();

        if(produto.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarProdutoPorId(@PathVariable Long id){
        ProdutoResponseDTO produto = produtoService.listarProdutoPorId(id);

        return ResponseEntity.ok(produto);
    }
}
