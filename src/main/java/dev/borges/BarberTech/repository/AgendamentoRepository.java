package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.AgendamentoModel;
import dev.borges.BarberTech.enums.StatusAgendamento;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

    List<AgendamentoModel> findByStatus(StatusAgendamento status);
}
