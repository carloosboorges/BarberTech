package dev.borges.BarberTech.enums;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status do Agendamento")
public enum StatusAgendamento {

    @Schema(description = "Agendamento agendado com sucesso.")
    AGENDADO,

    @Schema(description = "Agendamento cancelado com sucesso.")
    CANCELADO,

    @Schema(description = "Agendamento realizado com sucesso.")
    REALIZADO;

    public static StatusAgendamento from(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Status do agendamento não pode ser nulo.");
        }

        try {
            return StatusAgendamento.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Status do agendamento inválido: " + valor
            );
        }
    }
}
