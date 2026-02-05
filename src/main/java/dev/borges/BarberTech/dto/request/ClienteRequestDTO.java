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
@Schema(description = "Dados necessários para cadastrar ou atualizar um cliente")
public class ClienteRequestDTO{


    @NotBlank(message = "Nome é obrigatório")
    @Schema(description = "Nome do cliente", example = "Pedro Henrique")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Schema(description = "Email do cliente", example = "pedro@gmail.com")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    private  String telefone;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;



}
