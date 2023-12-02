package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.DTOs.requisicao.DadosCadastroRequisicao;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_requisicao")
public class CompraRequisicao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idRequisicao;

    @ManyToOne(targetEntity = CompraProduto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private List<CompraProduto> compraProduto;

    @ManyToOne(targetEntity = CompraFornecedor.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_forncedor")
    private List<CompraFornecedor> compraFornecedor;

    @ManyToOne(targetEntity = CompraCliente.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private List<CompraCliente> compraCliente;

    private Date dataRequisicao;
    private int quantidadeRequisicao;

    public CompraRequisicao(DadosCadastroRequisicao dados) {

        this.idRequisicao = dados.idRequisicao();
        this.compraProduto = dados.CompraProduto();
        this.compraFornecedor = dados.compraFornecedor();
        this.compraCliente = dados.compraCliente();
        this.dataRequisicao = dados.dataRequisicao();
        this.quantidadeRequisicao = dados.quantidadeRequisicao();
    }

    public void atualizarInformacoes(@Valid DadosCadastroRequisicao dados) {
        if (dados.idRequisicao() != null) {
            this.idRequisicao = dados.idRequisicao();
        }
        if (dados.CompraProduto() != null) {
            this.compraProduto = dados.CompraProduto();
        }
        if (dados.compraFornecedor() != null) {
            this.compraFornecedor = dados.compraFornecedor();
        }
        if (dados.compraCliente() != null) {
            this.compraCliente = dados.compraCliente();
        }
        if (dados.dataRequisicao() != null) {
            this.dataRequisicao = dados.dataRequisicao();
        }
        if (dados.quantidadeRequisicao() != 0) {
            this.quantidadeRequisicao = dados.quantidadeRequisicao();
        }
    }
}
