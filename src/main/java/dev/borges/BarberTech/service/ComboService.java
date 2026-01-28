package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.entity.ComboModel;
import dev.borges.BarberTech.entity.ServicoModel;
import dev.borges.BarberTech.mapper.ComboMapper;
import dev.borges.BarberTech.repository.ComboRepository;
import dev.borges.BarberTech.repository.ServicoRepository;
import org.springframework.stereotype.Service;

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

        if(request.getServicoIds() == null || request.getServicoIds().size() < 2){
            throw new IllegalArgumentException("O combo deve conter ao menos dois serviço.");
        }

        List<ServicoModel> servicos = servicoRepository.findAllById(request.getServicoIds());

        if(servicos.size() != request.getServicoIds().size()){
            throw new IllegalArgumentException("Um ou mais seriviços não encontrado.");
        }

        double valorOriginal = servicos.stream()
                .mapToDouble(ServicoModel::getValor)
                .sum();

        double valorComDesconto = valorOriginal - (valorOriginal * 0.10);

        ComboModel combo = new ComboModel(
                null,
                request.getNome(),
                valorComDesconto,
                servicos,
                null
        );

        ComboModel comboSalvo = comboRepository.save(combo);

        ComboResponseDTO response = comboMapper.toResponse(comboSalvo);

        response.setValorOriginal(valorOriginal);
        response.setValorComDesconto(valorComDesconto);

        return response;

    }
}