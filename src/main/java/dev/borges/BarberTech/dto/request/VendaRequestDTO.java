package dev.borges.BarberTech.dto.request;
import dev.borges.BarberTech.entity.ClienteModel;
import dev.borges.BarberTech.entity.ItemVendaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaRequestDTO {

    private LocalDate data;
    private Long clienteId;
    private List<ItemVendaRequestDTO> itens;


}
