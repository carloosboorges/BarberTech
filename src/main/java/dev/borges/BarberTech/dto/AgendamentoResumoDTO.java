package dev.borges.BarberTech.dto;
import dev.borges.BarberTech.enums.StatusAgendamento;
import java.time.LocalDateTime;

public class AgendamentoResumoDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String barbeiroNome;
    private String servicoOuCombo;
    private StatusAgendamento status;

}
