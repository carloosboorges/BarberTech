package dev.borges.BarberTech.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "item_venda_tb")
public class ItemVendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private Double precoUnitario;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    // PRODUTO
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;

    // VENDA
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private VendaModel venda;
}
