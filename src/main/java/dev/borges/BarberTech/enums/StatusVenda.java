package dev.borges.BarberTech.enums;

public enum StatusVenda {
    FINALIZADA,
    CANCELADA;

    public static StatusVenda from(String valor) {
        return StatusVenda.valueOf(valor.toUpperCase());
    }
}
