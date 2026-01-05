package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.ClienteRequestDTO;
import dev.borges.BarberTech.dto.ClienteResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import dev.borges.BarberTech.mapper.ClienteMapper;
import dev.borges.BarberTech.repository.ClienteRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDTO adicionarCliente(ClienteRequestDTO novoCliente){

        if(clienteRepository.existsByCpf(novoCliente.getCpf())){
            throw new EntityExistsException("CPF já cadastrado");
        }
        if(clienteRepository.existsByEmail(novoCliente.getEmail())){
            throw new EntityExistsException("Email já cadastrado");
        }
        ClienteModel clienteSalvo = clienteMapper.toModel(novoCliente);
        return clienteMapper.toResponse(clienteRepository.save(clienteSalvo));

    }

    public List<ClienteResponseDTO> listarClientes(){
        List<ClienteModel> cliente = clienteRepository.findAll();
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toResponse)
                .toList();
    }

    public ClienteResponseDTO listarPorId(Long id){
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return clienteMapper.toResponse(cliente);

    }

    public ClienteResponseDTO alterarCliente(ClienteRequestDTO request, Long id){
        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente com "+ id + "não encontrado."));

        if (!cliente.getCpf().equals(request.getCpf())
            && clienteRepository.existsByCpf(request.getCpf())){
            throw new EntityExistsException("CPF já cadastrado.");
        }

        if (!cliente.getEmail().equals(request.getEmail())
            && clienteRepository.existsByEmail(request.getEmail())){
            throw new EntityExistsException("Cliente com email já cadastrado.");
        }

        clienteMapper.updateFromDto(request, cliente);

        ClienteModel clienteSalvo = clienteRepository.save(cliente);

        return clienteMapper.toResponse(clienteSalvo);



    }


}
