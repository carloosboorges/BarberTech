package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponseDTO {

    private Long id;
    private String nomeServico;
    private BigDecimal valor;
    private int duracaoEstimadaMinutos;
}