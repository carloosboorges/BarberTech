package dev.borges.BarberTech.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Categoria é é obrigatória")
    private String categoria;

    @NotNull(message = "Preço é é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private Double preco;

    @NotNull(message = "Quantidade é obrigatório")
    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private Integer quantidadeEstoque;

}
