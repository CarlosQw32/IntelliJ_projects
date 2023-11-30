package org.example.domain.DTOs.usuario_medico;

import org.example.domain.entities.usuario_medico;

public record DadosListagemMedico (

        long crm_medico,
        String nome_medico,
        String senha_medico,
        String email_medico,
        String telefone_medico
){
    public DadosListagemMedico(usuario_medico medico) {
        this(medico.getCrm_medico(), medico.getNome_medico(), medico.getSenha_medico(), medico.getEmail_medico(), medico.getTelefone_medico());
    }
}
