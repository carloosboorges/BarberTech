package dev.borges.BarberTech.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarbeiroRequestDTO {

    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private boolean ativo;



}
