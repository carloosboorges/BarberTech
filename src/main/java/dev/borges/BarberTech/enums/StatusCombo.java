package dev.borges.BarberTech.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status do Combo")
public enum StatusCombo {

    @Schema(description = "Combo Ativo no sistema")
    ATIVO,

    @Schema(description = "Combo Inativo no sistema")
    INATIVO;

    public static StatusCombo from(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Status do combo não pode ser nulo.");
        }

        try {
            return StatusCombo.valueOf(valor.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Status do combo inválido: " + valor +
                    ". Valores aceitos: ATIVO, INAIVO"
            );
        }
    }
}

