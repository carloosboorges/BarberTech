package dev.borges.BarberTech.dto.request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequestDTO {

    @NotBlank(message = "Nome do serviço é obrigatório.")
    private String nomeServico;

    @NotNull(message = "Valor é obrigatório.")
    @Positive(message = "Valor deve ser maior que zero")
    private Double valor;

    @Min(value = 1, message = "Duração deve ser maior que zero")
    private int duracaoEstimadaMinutos;


}
