package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarbeiroResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private boolean ativo;


}

