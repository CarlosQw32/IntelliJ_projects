package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.DTOs.produto.DadosCadastroProduto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_produto")
public class CompraProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;

    @ManyToOne(targetEntity = CompraFornecedor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cnpj_fornecedor")
    private List<CompraFornecedor> compraFornecedor;

    private String descricaoProduto;
    private double valorProduto;
    private String aplicacaoProduto;

    public CompraProduto(DadosCadastroProduto dados){

        this.idProduto = dados.idProduto();
        this.compraFornecedor = dados.CompraFornecedor();
        this.descricaoProduto = dados.descricaoProduto();
        this.valorProduto = dados.valorProduto();
        this.aplicacaoProduto = dados.aplicacaoProduto();
    }

    public void atualizarInformacoes(DadosCadastroProduto dados) {
        if (dados.idProduto() != null) {
            this.idProduto = dados.idProduto();
        }
        if (dados.CompraFornecedor() != null) {
            this.compraFornecedor = dados.CompraFornecedor();
        }
        if (dados.descricaoProduto() != null) {
            this.descricaoProduto = dados.descricaoProduto();
        }
        if (dados.valorProduto() != 0) {
            this.valorProduto = dados.valorProduto();
        }
        if (dados.aplicacaoProduto() != null) {
            this.aplicacaoProduto = dados.aplicacaoProduto();
        }
    }
}
