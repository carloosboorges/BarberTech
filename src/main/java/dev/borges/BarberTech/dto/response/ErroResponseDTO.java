package dev.borges.BarberTech.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Estrutura padrão de erro retornada pela API")
public class ErroResponseDTO {

    @Schema(
            description = "Código HTTP do erro",
            example = "400"
    )
    private int status;

    @Schema(
            description = "Mensagem descritiva do erro",
            example = "CPF inválido"
    )
    private String mensagem;

    @Schema(
            description = "Data e hora em que o erro ocorreu",
            example = "2026-02-05T14:32:10"
    )
    private LocalDateTime timestamp;
}
