package org.example.domain.DTOs.produto;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraFornecedor;

import java.util.List;

public record DadosAtualizacaoProduto(

        @NotBlank
        Long idProduto,

        @NotBlank
        List<org.example.domain.entities.CompraFornecedor> CompraFornecedor,

        String descricaoProduto,
        double valorProduto,
        String aplicacaoProduto
) {
}
