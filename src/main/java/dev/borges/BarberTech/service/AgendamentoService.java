package dev.borges.BarberTech.service;

import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.entity.*;
import dev.borges.BarberTech.enums.StatusAgendamento;
import dev.borges.BarberTech.mapper.AgendamentoMapper;
import dev.borges.BarberTech.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper agendamentoMapper;
    private final ServicoRepository servicoRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ClienteRepository clienteRepository;
    private final ComboRepository comboRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, AgendamentoMapper agendamentoMapper, ServicoRepository servicoRepository, BarbeiroRepository barbeiroRepository, ClienteRepository clienteRepository, ComboRepository comboRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoMapper = agendamentoMapper;
        this.servicoRepository = servicoRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.clienteRepository = clienteRepository;
        this.comboRepository = comboRepository;
    }

    public AgendamentoResponseDTO criarAgendamento(AgendamentoRequestDTO request) {

        // 1️⃣ Validar cliente
        ClienteModel cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cliente com ID " + request.getClienteId() + " não encontrado."
                ));

        // 2️⃣ Validar barbeiro
        BarbeiroModel barbeiro = barbeiroRepository.findById(request.getBarbeiroId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Barbeiro com ID " + request.getBarbeiroId() + " não encontrado."
                ));

        // 3️⃣ Criar o agendamento base
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setDataHora(request.getDataHora());
        agendamento.setCliente(cliente);
        agendamento.setBarbeiro(barbeiro);
        agendamento.setStatus(StatusAgendamento.AGENDADO);

        // 4️⃣ Serviço OU Combo
        if (request.getServicoId() != null && request.getComboId() != null) {
            throw new IllegalArgumentException(
                    "Informe apenas serviço OU combo, não os dois."
            );
        }

        if (request.getServicoId() != null) {

            ServicoModel servico = servicoRepository.findById(request.getServicoId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Serviço com ID " + request.getServicoId() + " não encontrado."
                    ));

            agendamento.setServico(servico);
            agendamento.setCombo(null);

        } else if (request.getComboId() != null) {

            ComboModel combo = comboRepository.findById(request.getComboId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Combo com ID " + request.getComboId() + " não encontrado."
                    ));

            agendamento.setCombo(combo);
            agendamento.setServico(null);

        } else {
            throw new IllegalArgumentException(
                    "É obrigatório informar um serviço ou um combo."
            );
        }

        // 5️⃣ Salvar e retornar
        AgendamentoModel salvo = agendamentoRepository.save(agendamento);

        return agendamentoMapper.toResponse(salvo);
    }

    public List<AgendamentoResponseDTO> listarAgendamentos() {
        List<AgendamentoModel> agendamento = agendamentoRepository.findAll();

        return agendamentoMapper.toResponseList(agendamento);
    }

    public AgendamentoResponseDTO listarPorId(Long id) {
        AgendamentoModel agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com ID: " + id + " não encontrado"));

        return agendamentoMapper.toResponse(agendamento);

    }

    public List<AgendamentoResponseDTO> listarPorStatus(StatusAgendamento status) {
        List<AgendamentoModel> agendamento = agendamentoRepository.findByStatus(status);
        return agendamentoMapper.toResponseList(agendamento);
    }

    public AgendamentoResponseDTO atualizarAgendamento(Long id, AgendamentoRequestDTO request) {

        AgendamentoModel agendamnetoEncontrado = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com ID " + id + " não encontrado."));

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("O agendamento já foi cancelado e não pode ser alterado.");
        }

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.REALIZADO) {
            throw new IllegalArgumentException("O agendamento ja foi realizado e não pode ser alterado.");
        }

        if (request.getBarbeiroId() != null) {

            BarbeiroModel novoBarbeiro = barbeiroRepository
                    .findById(request.getBarbeiroId())
                    .orElseThrow(() -> new EntityNotFoundException("Barbeiro com ID " + request.getBarbeiroId() + " não encontrado."));

            if (!novoBarbeiro.isAtivo()) {
                throw new IllegalArgumentException("Barbeiro está inativo.");
            }

            agendamnetoEncontrado.setBarbeiro(novoBarbeiro);
        }

        if (request.getDataHora() != null) {

            if (request.getDataHora().isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("Não é permitido agendar para uma data/hora no passado.");
            }

            agendamnetoEncontrado.setDataHora(request.getDataHora());
        }

        if (agendamnetoEncontrado.getServico() != null && request.getComboId() != null) {
            throw new IllegalArgumentException("Não é possitvel alterar de SERVIÇO para COMBO, cancele o agendamento e refaça.");
        }

        if (agendamnetoEncontrado.getCombo() != null && request.getServicoId() != null) {
            throw new IllegalArgumentException("Não é possitvel alterar de COMBO para SERVIÇO, cancele o agendamento e refaça.");

        }

        if (agendamnetoEncontrado.getServico() != null && request.getServicoId() != null) {

            ServicoModel servico = servicoRepository.findById(request.getServicoId())
                    .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + request.getServicoId() + " não existe."));

            agendamnetoEncontrado.setServico(servico);
        }

        if (agendamnetoEncontrado.getCombo() != null && request.getComboId() != null) {

            ComboModel combo = comboRepository.findById(request.getComboId())
                    .orElseThrow(() -> new EntityNotFoundException("Serviço com ID " + request.getServicoId() + " não existe."));

            agendamnetoEncontrado.setCombo(combo);
        }

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.AGENDADO
                && agendamnetoEncontrado.getDataHora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Agendamento AGENDADO não pode ficar com data hora no passado.");
        }

        AgendamentoModel agendamantoSalvo = agendamentoRepository.save(agendamnetoEncontrado);

        return agendamentoMapper.toResponse(agendamantoSalvo);

    }

    public AgendamentoResponseDTO cancelarAgendamento(Long id) {
        AgendamentoModel agendamnetoEncontrado = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com ID " + id + " não encontrado."));

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("Agendamento ja está cancelado.");
        }

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.REALIZADO) {
            throw new IllegalArgumentException("Não pode cancelar algo que já foi realizado.");
        }

        agendamnetoEncontrado.setStatus(StatusAgendamento.CANCELADO);

        return agendamentoMapper.toResponse(agendamentoRepository.save(agendamnetoEncontrado));
    }

    public AgendamentoResponseDTO marcarComoRealizdo(Long id) {
        AgendamentoModel agendamnetoEncontrado = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento com ID " + id + " não encontrado."));

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.CANCELADO) {
            throw new IllegalArgumentException("Agendamento ja está cancelado.");
        }

        if (agendamnetoEncontrado.getStatus() == StatusAgendamento.REALIZADO) {
            throw new IllegalArgumentException("O agendamento já está realizado.");
        }

        agendamnetoEncontrado.setStatus(StatusAgendamento.REALIZADO);

        return agendamentoMapper.toResponse(agendamentoRepository.save(agendamnetoEncontrado));



    }


}
