package org.example.domain.DTOs.usuario_crianca;


import org.example.domain.entities.usuario_crianca;

public record DadosListagemCrianca(
        Long cpf_crian,
        String nome_crian,
        String genero_crian,
        String condicies_preexistentes_crian,
        String comunidade_crian,
        String etinia_crian) {

    public DadosListagemCrianca(usuario_crianca crianca) {
        this(crianca.getCpf_crian(), crianca.getNome_crian(), crianca.getGenero_crian(), crianca.getCondicies_preexistentes_crian(), crianca.getComunidade_crian(), crianca.getEtinia_crian());
    }
}
