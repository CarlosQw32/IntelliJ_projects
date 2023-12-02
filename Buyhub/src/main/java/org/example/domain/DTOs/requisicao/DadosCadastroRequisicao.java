package org.example.domain.DTOs.requisicao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraCliente;
import org.example.domain.entities.CompraFornecedor;
import org.example.domain.entities.CompraProduto;

import java.sql.Date;
import java.util.List;

public record DadosCadastroRequisicao(
        @NotBlank
        Long idRequisicao,
        @NotBlank
        List<CompraProduto> CompraProduto,
        @NotBlank
        List<CompraFornecedor> compraFornecedor,
        @NotBlank
        List<CompraCliente> compraCliente,

        Date dataRequisicao,
        int quantidadeRequisicao
) {
}
