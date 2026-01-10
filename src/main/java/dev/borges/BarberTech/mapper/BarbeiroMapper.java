package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.BarbeiroRequestDTO;
import dev.borges.BarberTech.dto.BarbeiroResponseDTO;
import dev.borges.BarberTech.entity.BarbeiroModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BarbeiroMapper {

    BarbeiroModel toModel (BarbeiroRequestDTO dto);

    BarbeiroResponseDTO toResponse(BarbeiroModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(BarbeiroRequestDTO dto, @MappingTarget BarbeiroModel model);

}
