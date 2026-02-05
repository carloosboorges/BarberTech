package dev.borges.BarberTech.dto.response;
import dev.borges.BarberTech.enums.StatusCombo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "Dados retornados de um combo")
public class ComboResponseDTO {

    @Schema(description = "Identificador único do combo", example = "1")
    private Long id;

    @Schema(description = "Nome do combo", example = "Combo Corte + Barba")
    private String nome;

    @Schema(
            description = "Valor original do combo sem desconto",
            example = "80.00"
    )
    private BigDecimal valorOriginal;

    @Schema(
            description = "Valor final do combo com desconto aplicado",
            example = "65.00"
    )
    private BigDecimal valorComDesconto;

    @Schema(description = "Lista de serviços que compõem o combo")
    private List<ServicoResumoDTO> servicos;

    @Schema(
            description = "Status atual do combo",
            example = "ATIVO"
    )
    private StatusCombo status;
}