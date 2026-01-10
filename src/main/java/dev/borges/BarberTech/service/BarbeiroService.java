package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.BarbeiroResponseDTO;
import dev.borges.BarberTech.entity.BarbeiroModel;
import dev.borges.BarberTech.mapper.BarbeiroMapper;
import dev.borges.BarberTech.repository.BarbeiroRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

@Service
public class BarbeiroService {

    private final BarbeiroMapper barbeiroMapper;
    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroMapper barbeiroMapper, BarbeiroRepository barbeiroRepository) {
        this.barbeiroMapper = barbeiroMapper;
        this.barbeiroRepository = barbeiroRepository;
    }

    public BarbeiroResponseDTO adicionarBarbeiro(BarbeiroRequestDTO novoBarbeiro){

        if(barbeiroRepository.existsByCpf(novoBarbeiro.getCpf())){
            throw new EntityExistsException("CPF já cadastrado.");
        }

        if(barbeiroRepository.existsByEmail(novoBarbeiro.getEmail())){
            throw new EntityExistsException("Email ja cadastrado");
        }

        BarbeiroModel barbeiro = barbeiroMapper.toModel(novoBarbeiro);
        return barbeiroMapper.toResponse(barbeiroRepository.save(barbeiro));
    }
}
