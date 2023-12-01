package org.example.domain.DTOs.consulta;

import org.example.domain.entities.consulta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryConsulta extends JpaRepository<consulta, Long> {
    Page<consulta> findAll(Pageable paginacao);
}
