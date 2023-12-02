package org.example.domain.DTOs.pedido;

import org.example.domain.entities.ComprasPedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPedido extends JpaRepository<ComprasPedido, Long> {
    Page<ComprasPedido> findAll(Pageable paginacao);
}
