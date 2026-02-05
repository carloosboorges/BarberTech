package dev.borges.BarberTech.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Item que compõe uma venda")
public class ItemVendaRequestDTO {

    @Schema(
            description = "ID do produto que será vendido",
            example = "5"
    )
    @NotNull(message = "O ID do produto é obrigatório.")
    private Long produtoId;

    @Schema(
            description = "Quantidade do produto na venda",
            example = "2"
    )
    @NotNull(message = "A quantidade é obrigatória.")
    @Min(value = 1, message = "A quantidade deve ser maior que zero.")
    private Integer quantidade;
}
