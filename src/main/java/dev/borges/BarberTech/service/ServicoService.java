package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.request.ServicoRequestDTO;
import dev.borges.BarberTech.dto.response.ServicoResponseDTO;
import dev.borges.BarberTech.entity.ServicoModel;
import dev.borges.BarberTech.mapper.ServicoMapper;
import dev.borges.BarberTech.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    public ServicoService(ServicoRepository servicoRepository, ServicoMapper servicoMapper) {
        this.servicoRepository = servicoRepository;
        this.servicoMapper = servicoMapper;
    }


    public ServicoResponseDTO adicionarServico(ServicoRequestDTO servicoDto){
        ServicoModel servico = servicoMapper.toModel(servicoDto);
        return servicoMapper.toResponse(servicoRepository.save(servico));

    }

    public List<ServicoResponseDTO> listarServicos() {
        List<ServicoModel> lista = servicoRepository.findAll();

        return lista.stream()
                .map(servicoMapper::toResponse)
                .toList();
    }

    public ServicoResponseDTO listarPorId(Long id){
        ServicoModel servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + id + " não encontrado."));

        return servicoMapper.toResponse(servico);
    }

    public ServicoResponseDTO atualizarServico(@PathVariable Long id, @RequestBody ServicoRequestDTO request){
        ServicoModel servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + id + " não encontrado."));

        servicoMapper.updateFromDto(request, servico);
        ServicoModel servicoSalvo = servicoRepository.save(servico);

        return servicoMapper.toResponse(servicoSalvo);

    }

    public void deletarServico(Long id){
        ServicoModel servico = servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + id + " não encontrado."));

        servicoRepository.delete(servico);
    }
}
