package org.example.domain.DTOs.orcamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.example.domain.entities.CompraCliente;
import org.example.domain.entities.CompraRequisicao;
import org.example.domain.entities.CompraFornecedor;
import org.example.domain.entities.CompraProduto;


import java.sql.Date;
import java.util.List;

public record DadosCadastroOrcamento(

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
