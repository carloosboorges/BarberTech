package dev.borges.BarberTech.dto.response;
import lombok.Data;

@Data
public class ServicoResumoDTO {

    private Long id;
    private String nomeServico;
    private Double valor;
    private int duracaoEstimadaMinutos;
}