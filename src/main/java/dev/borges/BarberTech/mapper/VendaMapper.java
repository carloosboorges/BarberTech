package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.response.ItemVendaResponseDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.entity.ItemVendaModel;
import dev.borges.BarberTech.entity.VendaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface VendaMapper {

    @Mapping(target = "clienteNome", source = "cliente.nome")
    VendaResponseDTO toResponse(VendaModel model);

    @Mapping(target = "produtoNome", source = "produto.nome")
    ItemVendaResponseDTO toItem (ItemVendaModel model);

   // @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   // void updateFromDto(VendaRequestDTO request, @MappingTarget VendaModel model);


}
