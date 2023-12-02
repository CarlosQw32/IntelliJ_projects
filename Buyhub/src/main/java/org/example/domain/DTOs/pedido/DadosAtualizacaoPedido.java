package org.example.domain.DTOs.pedido;

import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.*;

import java.sql.Date;
import java.util.List;

public record DadosAtualizacaoPedido(

        @NotBlank
        Long idPedido,

        @NotBlank
        List<org.example.domain.entities.CompraOrcamento> CompraOrcamento,
        @NotBlank
        List<CompraRequisicao> compraRequisicao,

        int quantidadePedido,
        Date dataPedido,
        @NotBlank
        List<CompraCliente> compraCliente,
        @NotBlank
        List<CompraFornecedor> compraFornecedor,
        @NotBlank
        List<CompraProduto> compraProduto
) {
}
