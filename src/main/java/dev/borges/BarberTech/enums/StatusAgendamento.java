package dev.borges.BarberTech.enums;

public enum StatusAgendamento {
    AGENDADO,
    CANCELADO,
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
