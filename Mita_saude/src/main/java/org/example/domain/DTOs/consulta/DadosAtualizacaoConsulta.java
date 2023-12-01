package org.example.domain.DTOs.consulta;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.usuario_crianca;
import org.example.domain.entities.usuario_medico;

import java.util.List;

public record DadosAtualizacaoConsulta(

        @NotBlank
        Long id_consulta,

        @NotBlank
        List<usuario_crianca> crianca,

        @NotBlank
        List<usuario_medico> medicos,

        String mes_1_consulta,
        String mes_2_consulta,
        String mes_3_consulta,
        String mes_4_consulta,
        String mes_5_consulta,
        String mes_6_consulta,
        String mes_7_consulta,
        String mes_8_consulta,
        String mes_9_consulta,
        String mes_10_consulta,
        String mes_11_consulta,
        String mes_12_consulta,
        String mes_13_consulta,
        String mes_14_consulta,
        String mes_15_consulta,
        String mes_16_consulta,
        String mes_17_consulta,
        String mes_18_consulta,
        String mes_19_consulta,
        String mes_20_consulta,
        String mes_21_consulta,
        String mes_22_consulta,
        String mes_23_consulta,
        String mes_24_consulta
) {
}
