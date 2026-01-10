package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.BarbeiroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<BarbeiroModel, Long > {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}
