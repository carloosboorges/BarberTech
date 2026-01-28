package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.request.ComboRequestDTO;
import dev.borges.BarberTech.dto.response.ComboResponseDTO;
import dev.borges.BarberTech.entity.ComboModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ServicoMapper.class})
public interface ComboMapper {

    // Request -> Model (sem serviços e sem valor)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "valor", ignore = true)
    @Mapping(target = "servicos", ignore = true)
    @Mapping(target = "agendamentos", ignore = true)
    ComboModel toModel(ComboRequestDTO dto);

    // Model -> Response
    ComboResponseDTO toResponse(ComboModel model);

    // Update parcial
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "servicos", ignore = true)
    @Mapping(target = "valor", ignore = true)
    void updateFromDto(ComboRequestDTO dto, @MappingTarget ComboModel model);
}
