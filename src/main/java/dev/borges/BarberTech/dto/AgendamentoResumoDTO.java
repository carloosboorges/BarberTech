package dev.borges.BarberTech.dto;

import dev.borges.BarberTech.enums.StatusAgendamento;

import java.time.LocalDateTime;
public record AgendamentoResumoDTO(

        Long id,
        LocalDateTime dataHora,
        String barbeiroNome,
        String servicoOuCombo,
        StatusAgendamento status
) {
}
