package dev.borges.BarberTech.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados necessários para realizar um agendamento")
public class AgendamentoRequestDTO {

    @Schema(
            description = "Data e hora do agendamento",
            example = "2026-02-10T14:00"
    )
    @NotNull(message = "Data e hora são obrigatórias")
    @Future(message = "A data do agendamento deve ser futura")
    private LocalDateTime dataHora;

    @Schema(
            description = "ID do cliente que está realizando o agendamento",
            example = "1"
    )
    @NotNull(message = "Cliente ID é obrigatório")
    private Long clienteId;

    @Schema(
            description = "ID do barbeiro que realizará o atendimento",
            example = "2"
    )
    @NotNull(message = "Barbeiro ID é obrigatório")
    private Long barbeiroId;

    @Schema(
            description = "ID do serviço. Deve ser informado quando o combo NÃO for utilizado",
            example = "5",
            nullable = true
    )
    private Long servicoId;

    @Schema(
            description = "ID do combo. Deve ser informado quando o serviço NÃO for utilizado",
            example = "3",
            nullable = true
    )
    private Long comboId;

    @AssertTrue(message = "Informe apenas UM: serviço ou combo")
    @Schema(
            description = "Validação interna: deve existir apenas serviço OU combo",
            hidden = true
    )
    public boolean isServicoOuComboValido() {
        return (servicoId != null && comboId == null)
                || (servicoId == null && comboId != null);
    }
}