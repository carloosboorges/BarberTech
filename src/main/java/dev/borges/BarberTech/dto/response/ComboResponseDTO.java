package dev.borges.BarberTech.dto.response;
import lombok.Data;

import java.util.List;

@Data
public class ComboResponseDTO {

    private Long id;
    private String nome;
    private Double valor;
    private List<ServicoResumoDTO> servicos;

}
