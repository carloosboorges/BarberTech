package dev.borges.BarberTech.dto;

import java.util.List;
public record ClienteResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf

) {
}
