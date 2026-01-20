package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaResponseDTO {
    private Long id;
    private LocalDate data;
    private String clienteNome;
    private Double valorTotal;
    private List<ItemVendaResponseDTO> itens;
}
