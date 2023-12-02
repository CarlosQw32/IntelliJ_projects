package org.example.domain.DTOs.produto;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraFornecedor;
import org.example.domain.entities.CompraOrcamento;
import org.example.domain.entities.CompraProduto;

import java.util.List;

public record DadosListagemProduto(


        Long idProduto,


        List<org.example.domain.entities.CompraFornecedor> CompraFornecedor,

        String descricaoProduto,
        double valorProduto,
        String aplicacaoProduto
) {
    public DadosListagemProduto(CompraProduto CompraProduto) {
        this(CompraProduto.getIdProduto(), CompraProduto.getCompraFornecedor(), CompraProduto.getDescricaoProduto(), CompraProduto.getValorProduto(),
                CompraProduto.getAplicacaoProduto());
    }
}
