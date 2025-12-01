package dev.borges.BarberTech.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente_tb")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    String telefone;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "cpf", unique = true)
    String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<AgendamentoModel> agendamentos;
}
