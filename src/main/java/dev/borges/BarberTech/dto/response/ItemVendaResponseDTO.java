package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaResponseDTO {
    private String produtoNome;
    private Double precoUnitario;
    private Integer quantidade;
}

