package dev.borges.BarberTech.entity;
import dev.borges.BarberTech.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agendamento_tb")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusAgendamento status;

    //Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    //Barbeiro
    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private BarbeiroModel barbeiro;

    //Serviço
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private ServicoModel servico;

    //Combo
    @ManyToOne
    @JoinColumn(name = "combo_id")
    private ComboModel combo;

}
