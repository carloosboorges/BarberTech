package dev.borges.BarberTech.repository;

import dev.borges.BarberTech.entity.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
}
