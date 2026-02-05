package dev.borges.BarberTech.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados necessários para cadastrar ou atualizar um barbeiro")
public class BarbeiroRequestDTO {


    @Schema(description = "Nome do babeiro", example = "Carlos Borges")
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Schema(description = "Telefone do barbeiro", example = "(81) 99107-8888")
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @Schema(description = "CPF do barbeiro",example = "10145995477")
    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @Schema(description = "Email do barbeiro", example = "carloos-boorges@hotmail.com")
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @Schema(description = "Indica se o barbeiro está ativo", example = "true")
    private boolean ativo;



}
