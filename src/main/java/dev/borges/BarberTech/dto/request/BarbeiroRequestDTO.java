package dev.borges.BarberTech.dto.request;
import lombok.Data;

@Data
public class BarbeiroRequestDTO {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private boolean ativo;



}
