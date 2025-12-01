package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {
}
