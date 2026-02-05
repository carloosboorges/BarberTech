package dev.borges.BarberTech.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados necessários para cadastrar ou atualizar um produto")
public class ProdutoRequestDTO {

    @Schema(description = "Nome do produto", example = "Pomada Modeladora")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Schema(description = "Categoria do produto", example = "Cabelo")
    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;

    @Schema(description = "Preço unitário do produto", example = "39.90")
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private BigDecimal preco;

    @Schema(description = "Quantidade disponível em estoque", example = "10")
    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 0, message = "Quantidade não pode ser negativa")
    private Integer quantidadeEstoque;
}
