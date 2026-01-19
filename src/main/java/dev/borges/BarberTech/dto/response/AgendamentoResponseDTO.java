package dev.borges.BarberTech.dto.response;
import dev.borges.BarberTech.enums.StatusAgendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponseDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String barbeiroNome;
    private String servicoOuCombo;
    private StatusAgendamento status;

}
