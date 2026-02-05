package dev.borges.BarberTech.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Dados necessários para cadastrar ou atualizar um combo")
public class ComboRequestDTO {

    @Schema(description = "Nome do combo", example = "Combo Corte + Barba")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(
            description = "Lista de IDs dos serviços que compõem o combo",
            example = "[1, 2, 3]"
    )
    @NotEmpty(message = "O combo deve conter pelo menos um serviço")
    @Size(min = 2, message = "O combo precisa ter no mínumo 2 serviços")
    private List<@NotNull(message = "ID do serviço não pode ser nulo") Long> servicoIds;
}
