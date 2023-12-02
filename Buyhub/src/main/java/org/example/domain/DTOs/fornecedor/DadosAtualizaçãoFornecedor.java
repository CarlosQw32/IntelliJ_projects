package org.example.domain.DTOs.fornecedor;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraOrcamento;
import org.example.domain.entities.CompraProduto;

import java.util.List;

public record DadosAtualizaçãoFornecedor(
        @NotBlank
        Long cnpjFornecedor,

        String senhaFornecedor,
        String nomeFornecedor,
        String ramoFornecedor,

        @NotBlank
        List<CompraOrcamento> compraOrcamentos,
        @NotBlank
        List<CompraProduto> compraProdutos
) {
}
