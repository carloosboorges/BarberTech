package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.ServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <ServicoModel, Long> {
}
