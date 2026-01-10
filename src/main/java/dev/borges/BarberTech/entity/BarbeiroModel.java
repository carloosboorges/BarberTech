package dev.borges.BarberTech.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barbeiro_tb")
public class BarbeiroModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "ativo")
    private boolean ativo;

    @OneToMany(mappedBy = "barbeiro")
    private List<AgendamentoModel> agendamento;
}
