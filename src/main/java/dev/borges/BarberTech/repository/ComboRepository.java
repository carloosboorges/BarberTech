package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.ComboModel;
import dev.borges.BarberTech.enums.StatusCombo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComboRepository extends JpaRepository<ComboModel, Long> {

    List<ComboModel> findByStatus(StatusCombo status);

}


