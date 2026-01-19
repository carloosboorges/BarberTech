package dev.borges.BarberTech.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {

    private String nome;
    private String categoria;
    private Double preco;
    private Integer quantidadeEstoque;

}
