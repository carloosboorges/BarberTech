package dev.borges.BarberTech.dto.request;
import lombok.Data;

import java.util.List;

@Data
public class ComboRequestDTO {

    private String nome;
    private Double valor;
    private List<Long> servicoIds;
}
