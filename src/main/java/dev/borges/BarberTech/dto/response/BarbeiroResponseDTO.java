package dev.borges.BarberTech.dto.response;
import lombok.Data;

@Data
public class BarbeiroResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private boolean ativo;


}

