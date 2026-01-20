package dev.borges.BarberTech.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaRequestDTO {

    private Long clienteId;
    private List<ItemVendaRequestDTO> itens;


}
