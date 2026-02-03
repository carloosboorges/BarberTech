package dev.borges.BarberTech.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequestDTO {

    private LocalDateTime dataHora;

    private Long clienteId;

    private Long barbeiroId;

    // Um ou outro, nunca os dois
    private Long servicoId;
    private Long comboId;
}
