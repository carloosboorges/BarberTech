package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.ClienteRequestDTO;
import dev.borges.BarberTech.dto.ClienteResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import dev.borges.BarberTech.mapper.ClienteMapper;
import dev.borges.BarberTech.repository.ClienteRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO adicionarCliente(ClienteRequestDTO novoCliente){

        if(clienteRepository.existsByCpf(novoCliente.cpf())){
            throw new EntityExistsException("CPF já cadastrado");
        }
        if(clienteRepository.existsByEmail(novoCliente.email())){
            throw new EntityExistsException("Email já cadastrado");
        }
        ClienteModel clienteSalvo = clienteMapper.toModel(novoCliente);
        return clienteMapper.toResponse(clienteRepository.save(clienteSalvo));

    }
}
