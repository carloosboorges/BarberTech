package dev.borges.BarberTech.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequestDTO {

    private String nomeServico;
    private Double valor;
    private int duracaoEstimadaMinutos;
}
