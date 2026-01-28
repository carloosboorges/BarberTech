package dev.borges.BarberTech.dto.response;
import lombok.Data;

import java.util.List;

@Data
public class ComboResponseDTO {

    private Long id;
    private String nome;

    private Double valorOriginal;
    private Double valorComDesconto;
    private List<ServicoResumoDTO> servicos;

}
