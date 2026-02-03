package dev.borges.BarberTech.service;

import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.entity.ComboModel;
import dev.borges.BarberTech.entity.ServicoModel;
import dev.borges.BarberTech.enums.StatusCombo;
import dev.borges.BarberTech.mapper.ComboMapper;
import dev.borges.BarberTech.repository.ComboRepository;
import dev.borges.BarberTech.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ComboService {

    private final ComboRepository comboRepository;
    private final ServicoRepository servicoRepository;
    private final ComboMapper comboMapper;


    public ComboService(ComboRepository comboRepository, ServicoRepository servicoRepository, ComboMapper comboMapper) {
        this.comboRepository = comboRepository;
        this.servicoRepository = servicoRepository;
        this.comboMapper = comboMapper;
    }

    public ComboResponseDTO criarCombo(ComboRequestDTO request) {

        if (request.getServicoIds() == null || request.getServicoIds().size() < 2) {
            throw new IllegalArgumentException("O combo deve conter ao menos dois serviço.");
        }

        List<ServicoModel> servicos = servicoRepository.findAllById(request.getServicoIds());

        if (servicos.size() != request.getServicoIds().size()) {
            throw new IllegalArgumentException("Um ou mais seriviços não encontrado.");
        }

        BigDecimal valorOriginal = servicos.stream()
                .map(ServicoModel::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal desconto = new BigDecimal("0.10");

        BigDecimal valorComDesconto = valorOriginal.subtract(
                valorOriginal.multiply(desconto)
        );

        ComboModel combo = new ComboModel(
                null,
                request.getNome(),
                valorOriginal,
                valorComDesconto,
                servicos,
                StatusCombo.ATIVO,
                null
        );

        ComboModel comboSalvo = comboRepository.save(combo);

        return comboMapper.toResponse(comboSalvo);
    }

    public List<ComboResponseDTO> listarCombos() {
        List<ComboModel> combos = comboRepository.findAll();

        return combos.stream()
                .map(comboMapper::toResponse)
                .toList();

    }

    public ComboResponseDTO listarPorId(Long id){
        ComboModel combo = comboRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Combo com " + id + " nao encontrado."));

        return comboMapper.toResponse(combo);
    }

    public ComboResponseDTO atualizarCombo(Long id, ComboRequestDTO request){
        ComboModel combo = comboRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Combo com " + id + " nao encontrado."));

        comboMapper.updateFromDto(request, combo);

        if(request.getServicoIds() != null && !request.getServicoIds().isEmpty()){
            List<ServicoModel> servicos = servicoRepository.findAllById(request.getServicoIds());

            if(servicos.size() != request.getServicoIds().size()){
                throw new IllegalArgumentException("Um ou mais serviços não encontrados.");
            }

            BigDecimal valorOriginal = servicos.stream()
                    .map(ServicoModel::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal desconto = new BigDecimal("0.10");
            BigDecimal valorComDesconto = valorOriginal.subtract(valorOriginal.multiply(desconto));

            combo.setServicos(servicos);
            combo.setValorOriginal(valorOriginal);
            combo.setValorComDesconto(valorComDesconto);
        }


        ComboModel comboSalvo = comboRepository.save(combo);

        return comboMapper.toResponse(comboSalvo);

    }

    public List<ComboResponseDTO> buscarPorStatus(StatusCombo status){
        return comboRepository.findByStatus(status)
                .stream()
                .map(comboMapper::toResponse)
                .toList();


    }

    public ComboResponseDTO inativarCombo(Long id){
        ComboModel combo = comboRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Combo com ID " + id + " não encontrado." ));

        if(combo.getStatus() == StatusCombo.INATIVO){
            throw  new IllegalArgumentException("Combo já esta indísponivel.");
        }
        combo.setStatus(StatusCombo.INATIVO);

        return comboMapper.toResponse(comboRepository.save(combo));

    }



}