package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.response.ServicoResumoDTO;
import dev.borges.BarberTech.entity.ServicoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicoResumoMapper {

    @Mapping(source = "nomeServico", target = "nomeServico")
    ServicoResumoDTO toResumo(ServicoModel model);
}

