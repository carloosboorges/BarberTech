package dev.borges.BarberTech.enums;

public enum StatusVenda {
    FINALIZADA,
    CANCELADA;

    public static StatusVenda from(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Status da venda não pode ser nulo.");
        }

        try {
            return StatusVenda.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Status da venda inválido: " + valor
            );
        }
    }
}

