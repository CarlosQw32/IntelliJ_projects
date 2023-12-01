package org.example.domain.DTOs.obito;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.usuario_crianca;

import java.util.Date;
import java.util.List;

public record DadosAtualizarObito(

        @NotBlank
        Long id_obito,

        @NotBlank
        List<usuario_crianca> crianca,
        String causa_obito,
        String local_obito,
        Date data_obito,
        double hora_obito
) {
}
