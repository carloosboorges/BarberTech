package dev.borges.BarberTech.dto.response;
import dev.borges.BarberTech.enums.StatusAgendamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um agendamento")
public class AgendamentoResponseDTO {

    @Schema(description = "Identificador único do agendamento", example = "10")
    private Long id;

    @Schema(
            description = "Data e hora do agendamento",
            example = "2026-02-10T14:00"
    )
    private LocalDateTime dataHora;

    @Schema(
            description = "Status atual do agendamento",
            example = "AGENDADO, CANCELADO OU REALIZADO"
    )
    private StatusAgendamento status;

    @Schema(description = "Nome do cliente", example = "Carlos Borges")
    private String clienteNome;

    @Schema(description = "Nome do barbeiro responsável", example = "João Silva")
    private String barbeiroNome;

    @Schema(
            description = "Nome do serviço (preenchido quando o agendamento for por serviço)",
            example = "Corte Masculino",
            nullable = true
    )
    private String servicoNome;

    @Schema(
            description = "Nome do combo (preenchido quando o agendamento for por combo)",
            example = "Combo Corte + Barba",
            nullable = true
    )
    private String comboNome;
}