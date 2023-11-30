package org.example.domain.DTOs.nascimento;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.usuario_crianca;
import org.example.domain.entities.usuario_medico;

import java.util.Date;
import java.util.List;

public record DadosAtualizacaoNascimento(
        @NotBlank
        Long id_nascimento,
        @NotBlank
        List<usuario_crianca> crianca,

        @NotBlank
        List<usuario_medico> medicos,

        double peso_nascimento,
        double altura_nascimento,
        Date data_nascimento,
        double hora_nascimento,
        boolean teste_pezinho_nascimento,
        String local_nascimento

) {
}
