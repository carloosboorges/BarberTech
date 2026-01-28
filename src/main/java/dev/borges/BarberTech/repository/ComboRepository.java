package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.ComboModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepository extends JpaRepository<ComboModel, Long> {
}
