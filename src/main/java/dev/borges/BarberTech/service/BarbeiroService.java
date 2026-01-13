package dev.borges.BarberTech.service;

import dev.borges.BarberTech.dto.request.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.response.BarbeiroResponseDTO;
import dev.borges.BarberTech.entity.BarbeiroModel;
import dev.borges.BarberTech.mapper.BarbeiroMapper;
import dev.borges.BarberTech.repository.BarbeiroRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroMapper barbeiroMapper;
    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroMapper barbeiroMapper, BarbeiroRepository barbeiroRepository) {
        this.barbeiroMapper = barbeiroMapper;
        this.barbeiroRepository = barbeiroRepository;
    }

    public BarbeiroResponseDTO adicionarBarbeiro(BarbeiroRequestDTO novoBarbeiro) {

        if (barbeiroRepository.existsByCpf(novoBarbeiro.getCpf())) {
            throw new EntityExistsException("CPF já cadastrado.");
        }
        if (barbeiroRepository.existsByEmail(novoBarbeiro.getEmail())) {
            throw new EntityExistsException("Email ja cadastrado");
        }
        BarbeiroModel barbeiro = barbeiroMapper.toModel(novoBarbeiro);
        return barbeiroMapper.toResponse(barbeiroRepository.save(barbeiro));
    }

    public List<BarbeiroResponseDTO> listarBarbeiro() {
        List<BarbeiroModel> barbeiros = barbeiroRepository.findAll();
        return barbeiros.stream()
                .map(barbeiroMapper::toResponse)
                .toList();
    }

    public BarbeiroResponseDTO listarPorId(Long id) {
        BarbeiroModel barbeiro = barbeiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro com ID" + id + " não encontrado"));
        return barbeiroMapper.toResponse(barbeiro);
    }

    public BarbeiroResponseDTO atualizarBarbeiro(Long id, BarbeiroRequestDTO request) {
        BarbeiroModel barbeiro = barbeiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro com ID" + id + " não encontrado"));

        if (!barbeiro.getEmail().equals(request.getEmail())
                && barbeiroRepository.existsByEmail(request.getEmail())) {
            throw new EntityExistsException("Barbeiro com Email já cadastrado.");
        }

        if (!barbeiro.getCpf().equals(request.getCpf())
                && barbeiroRepository.existsByCpf(request.getCpf())) {
            throw new EntityExistsException("Barbeiro com CPF já cadastrado.");
        }

        barbeiroMapper.updateFromDto(request, barbeiro);

        BarbeiroModel barbeiroSalvo = barbeiroRepository.save(barbeiro);

        return barbeiroMapper.toResponse(barbeiroSalvo);
    }

    public void deletarBarbeiro(Long id){
        BarbeiroModel barbeiro = barbeiroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Barbeiro com ID " + id + " não encontrado"));

        barbeiroRepository.delete(barbeiro);
    }


}

