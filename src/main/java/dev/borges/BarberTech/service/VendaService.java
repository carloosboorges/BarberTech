package dev.borges.BarberTech.service;

import dev.borges.BarberTech.dto.request.ItemVendaRequestDTO;
import dev.borges.BarberTech.dto.request.VendaRequestDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import dev.borges.BarberTech.entity.ItemVendaModel;
import dev.borges.BarberTech.entity.ProdutoModel;
import dev.borges.BarberTech.entity.VendaModel;
import dev.borges.BarberTech.mapper.VendaMapper;
import dev.borges.BarberTech.repository.ClienteRepository;
import dev.borges.BarberTech.repository.ProdutoRepository;
import dev.borges.BarberTech.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class VendaService {

    private final VendaMapper vendaMapper;
    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaMapper vendaMapper, VendaRepository vendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.vendaMapper = vendaMapper;
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public VendaResponseDTO registrarVenda(VendaRequestDTO request) {
        ClienteModel cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + request.getClienteId() + " não encontrado."));


        if (request.getItens() == null || request.getItens().isEmpty()) {
            throw new IllegalArgumentException("A venda deve conter ao menos 1 item.");
        }

        List<ItemVendaModel> itens = request.getItens()
                .stream()
                .map(item -> montarItem(item))
                .toList();

        double total = itens.stream()
                .mapToDouble(ItemVendaModel::getSubtotal)
                .sum();

        total = Math.round(total * 100.0) / 100.0;

        VendaModel venda = new VendaModel(
                null,
                LocalDateTime.now(),
                total,
                cliente,
                itens
        );

        itens.forEach(i -> i.setVenda(venda));

        return vendaMapper.toResponse(vendaRepository.save(venda));
    }

    private ItemVendaModel montarItem(ItemVendaRequestDTO request) {

        ProdutoModel produto = produtoRepository.findById(request.getProdutoId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        double subtotal = produto.getPreco() * request.getQuantidade();

        return new ItemVendaModel(
                null,
                request.getQuantidade(),
                produto.getPreco(),      // precoUnitario
                produto.getPreco() * request.getQuantidade(), // subtotal
                produto,
                null
        );
    }

}
