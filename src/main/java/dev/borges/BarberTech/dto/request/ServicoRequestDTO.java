package dev.borges.BarberTech.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados necessários para cadastrar ou atualizar um serviço")
public class ServicoRequestDTO {

    @Schema(
            description = "Nome do serviço",
            example = "Corte Masculino"
    )
    @NotBlank(message = "Nome do serviço é obrigatório.")
    private String nomeServico;

    @Schema(
            description = "Valor do serviço",
            example = "35.00"
    )
    @NotNull(message = "Valor é obrigatório.")
    @Positive(message = "Valor deve ser maior que zero")
    private BigDecimal valor;

    @Schema(
            description = "Duração estimada do serviço em minutos",
            example = "30"
    )
    @Min(value = 1, message = "Duração deve ser maior que zero")
    private int duracaoEstimadaMinutos;
}
