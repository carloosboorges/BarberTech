package dev.borges.BarberTech.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados retornados de um serviço")
public class ServicoResponseDTO {

    @Schema(description = "Identificador único do serviço", example = "3")
    private Long id;

    @Schema(description = "Nome do serviço", example = "Corte Masculino")
    private String nomeServico;

    @Schema(
            description = "Valor do serviço",
            example = "35.00"
    )
    private BigDecimal valor;

    @Schema(
            description = "Duração estimada do serviço em minutos",
            example = "30"
    )
    private int duracaoEstimadaMinutos;
}
