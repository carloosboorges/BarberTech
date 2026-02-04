package dev.borges.BarberTech.dto.request;
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
public class VendaRequestDTO {

    @NotNull(message = "O ID do cliente é obrigatório.")
    private Long clienteId;

    @NotEmpty(message = "A venda deve conter ao menos um item")
    @Valid
    private List<ItemVendaRequestDTO> itens;


}
