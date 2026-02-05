package dev.borges.BarberTech.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados do barbeiro")
public class BarbeiroResponseDTO {

    @Schema(description = "Identificador do barbeiro", example = "1")
    private Long id;

    @Schema(description = "Nome do barbeiro", example = "Carlos Borges")
    private String nome;

    @Schema(description = "Telefone do barbeiro", example = "(81) 99107-8888")
    private String telefone;

    @Schema(description = "CPF do barbeiro", example = "10145995477")
    private String cpf;

    @Schema(description = "Email do barbeiro", example = "carloos-boorges@hotmail.com")
    private String email;

    @Schema(description = "Indica se o barbeiro está ativo", example = "true")
    private boolean ativo;
}

