package dev.borges.BarberTech.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "servico_tb")
public class ServicoModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome_servico")
    private String nomeServico;

    @Column(name = "valor")
    double valor;

    @Column(name = "duracao_estimada_minutos")
    private int duracaoEstimadaMinutos;

    @OneToMany(mappedBy = "servico")
    private List<AgendamentoModel> agendamentos;

    @ManyToMany(mappedBy = "servicos")
    private List<ComboModel> combos;


}
