package dev.borges.BarberTech.controller;

import dev.borges.BarberTech.dto.request.ProdutoRequestDTO;
import dev.borges.BarberTech.dto.response.ProdutoResponseDTO;
import dev.borges.BarberTech.service.ProdutoService;
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
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Operações relacionadas ás produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(
            summary = "Registra um novo produto ",
            description = "Cadastra um novo produto no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Barbeiro registrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para registrar um novo barbeiro"),
    })
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> adicionarProduto(@RequestBody ProdutoRequestDTO request) {
        ProdutoResponseDTO produto = produtoService.adicionarProtudo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @Operation(summary = "Lista todos os produtos")
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produto = produtoService.listarProdutos();

        if (produto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Lista um produto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> listarProdutoPorId(@PathVariable Long id) {
        ProdutoResponseDTO produto = produtoService.listarProdutoPorId(id);

        return ResponseEntity.ok(produto);
    }

    @Operation(
            summary = "Atualiza um novo produto ",
            description = "Atualiza um novo produto no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para atualizar um produto"),
            @ApiResponse(responseCode = "404", description = "Produto nao encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO produto = produtoService.atualizarProduto(id, requestDTO);

        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Deleta um produto", description = "Deleta um produto do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
