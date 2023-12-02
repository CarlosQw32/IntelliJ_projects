package org.example.domain.DTOs.orcamento;

import org.example.domain.entities.CompraOrcamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOrcamento extends JpaRepository<CompraOrcamento, Long> {
    Page<CompraOrcamento> findAll(Pageable paginacao);
}
