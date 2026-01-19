package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponseDTO {

    private Long id;
    private String nomeServico;
    private Double valor;
    private int duracaoEstimadaMinutos;
}