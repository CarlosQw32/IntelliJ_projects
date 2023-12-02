package org.example.domain.DTOs.orcamento;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosListagemOrcamento (


        Long idOrcamento,

        List<CompraRequisicao> Requisicao,

        Date dataOrcamento,

        List<CompraCliente> Cliente,

        List<CompraFornecedor> compraFornecedor,

        List<CompraProduto> compraProduto
){
    public DadosListagemOrcamento(CompraOrcamento CompraOrcamento) {
        this(CompraOrcamento.getIdOrcamento(), CompraOrcamento.getRequisicao(), CompraOrcamento.getDataOrcamento(), CompraOrcamento.getCompraCliente(),
                CompraOrcamento.getCompraFornecedor(), CompraOrcamento.getCompraProduto());
    }
}
