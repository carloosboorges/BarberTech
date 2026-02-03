package dev.borges.BarberTech.enums;

public enum StatusCombo {
    ATIVO,
    INATIVO;

    public static StatusCombo from(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Status do combo não pode ser nulo.");
        }

        try {
            return StatusCombo.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Status do combo inválido: " + valor
            );
        }
    }
}

