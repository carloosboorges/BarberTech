package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.request.ProdutoRequestDTO;
import dev.borges.BarberTech.dto.response.ProdutoResponseDTO;
import dev.borges.BarberTech.entity.ProdutoModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoModel toModel (ProdutoRequestDTO dto);

    ProdutoResponseDTO toResponse (ProdutoModel model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ProdutoRequestDTO dto, @MappingTarget ProdutoModel model);
}
