package org.example.domain.DTOs.usuario_crianca;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCrianca(
        @NotNull
        Long cpf_crian,
        String nome_crian,
        String genero_crian,
        String condicies_preexistentes_crian,
        String comunidade_crian,
        String etinia_crian) {
}
