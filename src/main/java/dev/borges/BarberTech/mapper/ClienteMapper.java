package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.request.ClienteRequestDTO;
import dev.borges.BarberTech.dto.response.ClienteResponseDTO;
import dev.borges.BarberTech.entity.ClienteModel;
import org.mapstruct.*;
@Mapper(componentModel = "spring")

public interface ClienteMapper {

    ClienteModel toModel(ClienteRequestDTO dto);

    ClienteResponseDTO toResponse(ClienteModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ClienteRequestDTO dto, @MappingTarget ClienteModel model);



}

