package org.example.domain.DTOs.nascimento;

import org.example.domain.entities.nascimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryNascimento extends JpaRepository<nascimento, Long> {
    Page<nascimento> findAll(Pageable paginacao);
}
