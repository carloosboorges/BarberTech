package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.ClienteRequestDTO;
import dev.borges.BarberTech.dto.ClienteResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import org.mapstruct.*;
@Mapper(componentModel = "spring")

public interface ClienteMapper {

    ClienteModel toModel(ClienteRequestDTO dto);

    ClienteResponseDTO toResponse(ClienteModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ClienteRequestDTO dto, @MappingTarget ClienteModel model);



}

