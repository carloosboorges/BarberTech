package dev.borges.BarberTech.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ComboRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Size(min = 2, message = "Combo deve ter entre 1 e 10 serviços")
    private List<@NotNull Long> servicoIds;
}
