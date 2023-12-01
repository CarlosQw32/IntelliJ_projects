package org.example.domain.DTOs.obito;


import org.example.domain.entities.obito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryObito extends JpaRepository<obito, Long> {
    Page<obito> findAll(Pageable paginacao);
}
