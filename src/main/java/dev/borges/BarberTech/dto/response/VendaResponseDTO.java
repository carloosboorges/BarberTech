package dev.borges.BarberTech.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dados retornados após o registro ou consulta de uma venda")
public class VendaResponseDTO {

    @Schema(description = "Identificador único da venda", example = "15")
    private Long id;

    @Schema(
            description = "Data e hora em que a venda foi realizada",
            example = "05/02/2026 14:30"
    )
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;

    @Schema(
            description = "Nome do cliente associado à venda",
            example = "Carlos Borges"
    )
    private String clienteNome;

    @Schema(
            description = "Valor total da venda",
            example = "119.80"
    )
    private BigDecimal valorTotal;

    @Schema(
            description = "Status atual da venda",
            example = "FINALIZADA"
    )
    private String status;

    @Schema(
            description = "Lista de itens que compõem a venda"
    )
    private List<ItemVendaResponseDTO> itens;
}
