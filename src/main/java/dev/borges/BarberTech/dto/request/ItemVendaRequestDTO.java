package dev.borges.BarberTech.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaRequestDTO {

    @NotNull(message = "O ID do produto é obrigatório.")
    private Long produtoId;

    @NotNull(message = "A quantidade é obrigatorio.")
    @Min(value = 1, message = "A quantidade deve ser maior que zero.")
    private Integer quantidade;

}