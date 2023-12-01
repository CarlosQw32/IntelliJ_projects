package org.example.domain.DTOs.carteira_vacinacao;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.usuario_crianca;

import java.util.List;

public record DadosAtualizacaoCarteiraVacinacao(

        @NotBlank
        Long id_carteira_vacinacao,

        @NotBlank
        List<usuario_crianca> crianca,

        String vacina_ao_nascer,
        String vacina_mes_1,
        String vacina_mes_2,
        String vacina_mes_4,
        String vacina_mes_6,
        String vacina_mes_9,
        String vacina_mes_12,
        String vacina_mes_15
) {
}
