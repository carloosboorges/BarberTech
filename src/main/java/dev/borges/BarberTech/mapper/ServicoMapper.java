package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.request.ServicoRequestDTO;
import dev.borges.BarberTech.dto.response.ServicoResponseDTO;
import dev.borges.BarberTech.entity.ServicoModel;
import org.mapstruct.*;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    ServicoModel toModel (ServicoRequestDTO dto);

    ServicoResponseDTO toResponse (ServicoModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ServicoRequestDTO dto, @MappingTarget ServicoModel model);

}
