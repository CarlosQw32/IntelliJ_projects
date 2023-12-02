package org.example.domain.DTOs.requisicao;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraCliente;
import org.example.domain.entities.CompraFornecedor;
import org.example.domain.entities.CompraProduto;
import org.example.domain.entities.CompraRequisicao;

import java.sql.Date;
import java.util.List;

public record DadosListagemRequisicao(


        Long idRequisicao,

        List<org.example.domain.entities.CompraProduto> CompraProduto,

        List<CompraFornecedor> compraFornecedor,

        List<CompraCliente> compraCliente,

        Date dataRequisicao,
        int quantidadeRequisicao) {


    public DadosListagemRequisicao(CompraRequisicao CompraRequisicao) {
        this(CompraRequisicao.getIdRequisicao(), CompraRequisicao.getCompraProduto(), CompraRequisicao.getCompraFornecedor(), CompraRequisicao.getCompraCliente(),
                CompraRequisicao.getDataRequisicao(), CompraRequisicao.getQuantidadeRequisicao());
    }
}
