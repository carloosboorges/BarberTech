package dev.borges.BarberTech.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaRequestDTO {
    private Long produtoId;
    private Integer quantidade;

}