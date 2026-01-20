package dev.borges.BarberTech.repository;

import dev.borges.BarberTech.entity.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaModel, Long> {
}
