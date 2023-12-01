package org.example.domain.DTOs.obito;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.nascimento;
import org.example.domain.entities.obito;
import org.example.domain.entities.usuario_crianca;

import java.util.Date;
import java.util.List;

public record DadosListagemObito(


        Long id_obito,
        List<usuario_crianca> crianca,
        String causa_obito,
        String local_obito,
        Date data_obito,
        double hora_obito
) {
    public DadosListagemObito(obito obito) {
        this(obito.getId_obito(), obito.getCrianca(), obito.getCausa_obito(), obito.getLocal_obito(), obito.getData_obito(),
                obito.getHora_obito());
    }
}
