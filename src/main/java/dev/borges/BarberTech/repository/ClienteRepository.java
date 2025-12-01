package dev.borges.BarberTech.repository;
import dev.borges.BarberTech.entity.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}
