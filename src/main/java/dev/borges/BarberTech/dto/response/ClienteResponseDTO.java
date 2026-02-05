package dev.borges.BarberTech.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados do cliente")
public class ClienteResponseDTO {

    @Schema(description = "Identificador único do cliente", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente", example = "Carlos Borges")
    private String nome;

    @Schema(description = "Email do cliente", example = "carlos.borges@email.com")
    private String email;

    @Schema(description = "Telefone do cliente", example = "(81) 99107-8888")
    private String telefone;

    @Schema(description = "CPF do cliente", example = "52998224725")
    private String cpf;
}