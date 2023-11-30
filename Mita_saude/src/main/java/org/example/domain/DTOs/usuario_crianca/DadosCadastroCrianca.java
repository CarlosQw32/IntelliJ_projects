package org.example.domain.DTOs.usuario_crianca;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCrianca(
        @NotBlank
        Long cpf_crian,
        @NotBlank
        String nome_crian,
        @NotBlank
        String genero_crian,
        @NotBlank
        String condicies_preexistentes_crian,
        @NotBlank
        String comunidade_crian,
        @NotBlank
        String etinia_crian) {

}
