package dev.borges.BarberTech.dto.response;
import dev.borges.BarberTech.enums.StatusCombo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ComboResponseDTO {

    private Long id;
    private String nome;

    private BigDecimal valorOriginal;
    private BigDecimal valorComDesconto;
    private List<ServicoResumoDTO> servicos;
    private StatusCombo status;

}
