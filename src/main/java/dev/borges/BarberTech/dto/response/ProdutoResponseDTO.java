package dev.borges.BarberTech.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados de um produto")
public class ProdutoResponseDTO {

    @Schema(description = "Identificador único do produto", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "Pomada Modeladora")
    private String nome;

    @Schema(description = "Categoria do produto", example = "Cabelo")
    private String categoria;

    @Schema(description = "Preço unitário do produto", example = "39.90")
    private BigDecimal preco;

    @Schema(description = "Quantidade disponível em estoque", example = "10")
    private Integer quantidadeEstoque;
}
