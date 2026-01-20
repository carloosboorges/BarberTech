package dev.borges.BarberTech.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "venda_tb")
public class VendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    @Column(name = "data_venda", nullable = false)
    private LocalDateTime data;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @ManyToOne
    private ClienteModel cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVendaModel> itens;
}
