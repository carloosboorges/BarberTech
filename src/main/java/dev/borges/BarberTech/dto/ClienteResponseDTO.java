package dev.borges.BarberTech.dto;
import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

}
