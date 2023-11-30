package org.example.contollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.domain.DTOs.usuario_medico.RepositoryUsuarioMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Medicos")
@Tag(name = "Medicos",description = "CRUD dos Medicos.")
public class MedicoController {

    @Autowired
    private RepositoryUsuarioMedico repository;


}
