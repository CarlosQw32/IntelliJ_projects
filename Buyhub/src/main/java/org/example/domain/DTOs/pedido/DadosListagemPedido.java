package org.example.domain.DTOs.pedido;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosListagemPedido(


        Long idPedido,


        List<org.example.domain.entities.CompraOrcamento> CompraOrcamento,

        List<CompraRequisicao> compraRequisicao,

        int quantidadePedido,
        Date dataPedido,

        List<CompraCliente> compraCliente,

        List<CompraFornecedor> compraFornecedor,

        List<CompraProduto> compraProduto
) {
    public DadosListagemPedido(ComprasPedido ComprasPedido) {
        this(ComprasPedido.getIdPedido(), ComprasPedido.getCompraOrcamento(), ComprasPedido.getCompraRequisicao(), ComprasPedido.getQuantidadePedido(),
                ComprasPedido.getDataPedido(), ComprasPedido.getCompraCliente(), ComprasPedido.getCompraFornecedor(), ComprasPedido.getCompraProduto());
    }
}
