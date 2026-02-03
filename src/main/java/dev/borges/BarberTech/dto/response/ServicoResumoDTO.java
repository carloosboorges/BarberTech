package dev.borges.BarberTech.dto.response;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoResumoDTO {

    private Long id;
    private String nomeServico;
    private BigDecimal valor;
    private int duracaoEstimadaMinutos;
}