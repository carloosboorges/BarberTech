package dev.borges.BarberTech.entity;

import dev.borges.BarberTech.enums.StatusCombo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "combo_tb")
public class ComboModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor_original", precision = 10, scale = 2)
    private BigDecimal valorOriginal;

    @Column(name = "valor_com_desconto", precision = 10, scale = 2)
    private BigDecimal valorComDesconto;


    @ManyToMany
    @JoinTable(name = "combo_servico_tb",
            joinColumns = @JoinColumn(name = "combo_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<ServicoModel> servicos;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusCombo status;

    @OneToMany(mappedBy = "combo")
    private List<AgendamentoModel> agendamentos;
}
