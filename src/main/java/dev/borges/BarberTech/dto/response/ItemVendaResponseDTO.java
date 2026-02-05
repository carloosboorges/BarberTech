package dev.borges.BarberTech.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Item retornado na visualização de uma venda")
public class ItemVendaResponseDTO {

    @Schema(
            description = "Nome do produto vendido",
            example = "Pomada Modeladora"
    )
    private String produtoNome;

    @Schema(
            description = "Preço unitário do produto no momento da venda",
            example = "39.90"
    )
    private BigDecimal precoUnitario;

    @Schema(
            description = "Quantidade do produto vendida",
            example = "2"
    )
    private Integer quantidade;
}
