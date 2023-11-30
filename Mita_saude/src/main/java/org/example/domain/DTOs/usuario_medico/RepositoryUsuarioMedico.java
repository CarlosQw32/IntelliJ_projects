package org.example.domain.DTOs.usuario_medico;

import org.example.domain.entities.usuario_medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuarioMedico extends JpaRepository<usuario_medico, Long> {
    Page<usuario_medico> findAll(Pageable paginacao);
}
