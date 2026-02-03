package dev.borges.BarberTech.mapper;

import dev.borges.BarberTech.dto.response.AgendamentoResponseDTO;
import dev.borges.BarberTech.entity.AgendamentoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {

    @Mapping(source = "cliente.nome", target = "clienteNome")
    @Mapping(source = "barbeiro.nome", target = "barbeiroNome")
    @Mapping(source = "servico.nomeServico", target = "servicoNome")
    @Mapping(source = "combo.nome", target = "comboNome")
    AgendamentoResponseDTO toResponse(AgendamentoModel agendamento);

    List<AgendamentoResponseDTO> toResponseList(List<AgendamentoModel> agendamentos);
}



