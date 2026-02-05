package dev.borges.BarberTech.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status da venda")
public enum StatusVenda {

    @Schema(description = "Venda finalizada com sucesso")
    FINALIZADA,

    @Schema(description = "Venda cancelada no sistema")
    CANCELADA;

    public static StatusVenda from(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Status da venda não pode ser nulo.");
        }

        try {
            return StatusVenda.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Status da venda inválido: " + valor +
                            ". Valores aceitos: FINALIZADA, CANCELADA"
            );
        }
    }
}

