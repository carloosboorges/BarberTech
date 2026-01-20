package dev.borges.BarberTech.service;

import dev.borges.BarberTech.dto.request.ProdutoRequestDTO;
import dev.borges.BarberTech.dto.response.ProdutoResponseDTO;
import dev.borges.BarberTech.entity.ProdutoModel;
import dev.borges.BarberTech.mapper.ProdutoMapper;
import dev.borges.BarberTech.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }


    public ProdutoResponseDTO adicionarProtudo(ProdutoRequestDTO request) {
        ProdutoModel produto = produtoMapper.toModel(request);
        return produtoMapper.toResponse(produtoRepository.save(produto));
    }

    public List<ProdutoResponseDTO> listarProdutos() {
        List<ProdutoModel> produto = produtoRepository.findAll();
        return produto.stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public ProdutoResponseDTO listarProdutoPorId(Long id) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado."));

        return produtoMapper.toResponse(produto);
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO request) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado."));

        produtoMapper.updateFromDto(request, produto);

        ProdutoModel produtoSalvo = produtoRepository.save(produto);

        return produtoMapper.toResponse(produtoSalvo);
    }

    public void deletarProduto(Long id) {
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado."));

        produtoRepository.delete(produto);
    }
}
