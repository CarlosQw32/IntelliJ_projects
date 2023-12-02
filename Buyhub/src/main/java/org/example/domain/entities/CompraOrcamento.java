package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.DTOs.orcamento.DadosCadastroOrcamento;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_orcamento")
public class CompraOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOrcamento;

    @ManyToOne(targetEntity = CompraRequisicao.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_requisicao")
    private List<CompraRequisicao> Requisicao;

    private Date dataOrcamento;

    @ManyToOne(targetEntity = CompraCliente.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private List<CompraCliente> compraCliente;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpjFornecedor")
    private List<CompraFornecedor> compraFornecedor;

    @ManyToOne(targetEntity = CompraProduto.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private List<CompraProduto> compraProduto;

    public CompraOrcamento(DadosCadastroOrcamento dados){
        this.idOrcamento = dados.idOrcamento();
        this.Requisicao = dados.Requisicao();
        this.dataOrcamento = dados.dataOrcamento();
        this.compraCliente = dados.Cliente();
        this.compraFornecedor = dados.compraFornecedor();
        this.compraProduto = dados.compraProduto();

    }

    public void atualizarInformacoes(@Valid DadosCadastroOrcamento dados) {
        if (dados.idOrcamento() != null) {
            this.idOrcamento = dados.idOrcamento();
        }
        if (dados.Requisicao() != null) {
            this.Requisicao = dados.Requisicao();
        }
        if (dados.dataOrcamento() != null) {
            this.dataOrcamento = dados.dataOrcamento();
        }
        if (dados.Cliente() != null) {
            this.compraCliente = dados.Cliente();
        }
        if (dados.compraFornecedor() != null) {
            this.compraFornecedor = dados.compraFornecedor();
        }
        if (dados.compraProduto() != null) {
            this.compraProduto = dados.compraProduto();
        }
    }
}
