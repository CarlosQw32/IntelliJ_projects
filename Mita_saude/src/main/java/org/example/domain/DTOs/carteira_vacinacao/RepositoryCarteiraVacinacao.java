package org.example.domain.DTOs.carteira_vacinacao;

import org.example.domain.entities.carteira_vacinacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCarteiraVacinacao extends JpaRepository<carteira_vacinacao, Long> {
    Page<carteira_vacinacao> findAll(Pageable paginacao);
}
