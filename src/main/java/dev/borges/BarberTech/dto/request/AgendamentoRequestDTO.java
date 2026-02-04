package dev.borges.BarberTech.dto.request;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {

    @NotNull(message = "Data e hora são obrigatórias")
    private LocalDateTime dataHora;

    @NotNull(message = "Cliente ID é obrigatório")
    private Long clienteId;

    @NotNull(message = "Barbeiro ID é obrigatório")
    private Long barbeiroId;

    // Um ou outro, nunca os dois
    private Long servicoId;
    private Long comboId;

    @AssertTrue(message = "Informe apenas serviço OU combo")
    public boolean isServicoOuComboValido() {
        return (servicoId != null && comboId == null)
                || (servicoId == null && comboId != null);
    }
}
