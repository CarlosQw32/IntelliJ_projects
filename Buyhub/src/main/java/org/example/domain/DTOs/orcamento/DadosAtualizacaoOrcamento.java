package org.example.domain.DTOs.orcamento;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraCliente;
import org.example.domain.entities.CompraFornecedor;
import org.example.domain.entities.CompraProduto;
import org.example.domain.entities.CompraRequisicao;

import java.sql.Date;
import java.util.List;

public record DadosAtualizacaoOrcamento(

        @NotBlank
        Long idOrcamento,

        @NotBlank
        List<CompraRequisicao> Requisicao,

        Date dataOrcamento,
        @NotBlank
        List<CompraCliente> Cliente,

        @NotBlank
        List<CompraFornecedor> compraFornecedor,

        @NotBlank
        List<CompraProduto> compraProduto
) {
}
