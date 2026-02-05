package dev.borges.BarberTech.dto.request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dados necessários para registrar uma venda")
public class VendaRequestDTO {

    @Schema(description = "ID do cliente que realizou a compra", example = "1")
    @NotNull(message = "O ID do cliente é obrigatório.")
    private Long clienteId;

    @Schema(description = "Lista de itens da venda", example = "[{ \"produtoId\": 5, \"quantidade\": 2 }]"
    )
    @NotEmpty(message = "A venda deve conter ao menos um item")
    @Valid
    private List<ItemVendaRequestDTO> itens;


}
