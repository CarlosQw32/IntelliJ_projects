package org.example.domain.DTOs.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraFornecedor;

import java.util.List;

public record DadosCadastroProduto(

        @NotBlank
        Long idProduto,

        @NotBlank
        List<CompraFornecedor> CompraFornecedor,

        String descricaoProduto,
        double valorProduto,
        String aplicacaoProduto
) {
}
