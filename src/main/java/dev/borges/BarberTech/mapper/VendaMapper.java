package dev.borges.BarberTech.mapper;
import dev.borges.BarberTech.dto.response.ItemVendaResponseDTO;
import dev.borges.BarberTech.dto.response.VendaResponseDTO;
import dev.borges.BarberTech.entity.ItemVendaModel;
import dev.borges.BarberTech.entity.VendaModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface VendaMapper {


    VendaResponseDTO toResponse(VendaModel model);

    ItemVendaResponseDTO toItem (ItemVendaModel model);

   // @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   // void updateFromDto(VendaRequestDTO request, @MappingTarget VendaModel model);


}
