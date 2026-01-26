package dev.borges.BarberTech.repository;

import dev.borges.BarberTech.entity.VendaModel;
import dev.borges.BarberTech.enums.StatusVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends JpaRepository<VendaModel, Long> {

    List<VendaModel> findByClienteId(Long clienteId);

    List<VendaModel> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);

    List<VendaModel> findByStatus(StatusVenda status);

}
