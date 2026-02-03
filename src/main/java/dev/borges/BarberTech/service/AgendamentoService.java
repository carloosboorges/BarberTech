package dev.borges.BarberTech.service;
import dev.borges.BarberTech.dto.request.AgendamentoRequestDTO;
import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.entity.*;
import dev.borges.BarberTech.enums.StatusAgendamento;
import dev.borges.BarberTech.mapper.AgendamentoMapper;
import dev.borges.BarberTech.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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

        // 4️⃣ Serviço OU Combo (regra mais importante)
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

}
