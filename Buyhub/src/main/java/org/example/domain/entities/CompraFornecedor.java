package org.example.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.domain.DTOs.fornecedor.DadosCadastroFornecedor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "compra_fornecedor")
public class CompraFornecedor {

    @Id
    private long cnpjFornecedor;

    private String senhaFornecedor;
    private String nomeFornecedor;
    private String ramoFornecedor;

    @OneToMany(mappedBy = "compraFornecedor", fetch = FetchType.LAZY)
    private List<CompraOrcamento> compraOrcamentos;

    @OneToMany(mappedBy = "compraFornecedor", fetch = FetchType.LAZY)
    private List<CompraProduto> compraProdutos;


    public CompraFornecedor (DadosCadastroFornecedor dados){

        this.cnpjFornecedor = dados.cnpjFornecedor();
        this.senhaFornecedor = dados.senhaFornecedor();
        this.nomeFornecedor = dados.nomeFornecedor();
        this.ramoFornecedor = dados.ramoFornecedor();
        this.compraOrcamentos = dados.compraOrcamentos();
        this.compraProdutos = dados.compraProdutos();
    }

    public void atualizarInformacoes(@Valid DadosCadastroFornecedor dados) {
        if (dados.cnpjFornecedor() != null) {
            this.cnpjFornecedor = dados.cnpjFornecedor();
        }
        if (dados.senhaFornecedor() != null) {
            this.senhaFornecedor = dados.senhaFornecedor();
        }
        if (dados.nomeFornecedor() != null) {
            this.nomeFornecedor = dados.nomeFornecedor();
        }
        if (dados.ramoFornecedor() != null) {
            this.ramoFornecedor = dados.ramoFornecedor();
        }
        if (dados.compraOrcamentos() != null) {
            this.compraOrcamentos = dados.compraOrcamentos();
        }
        if (dados.compraProdutos() != null) {
            this.compraProdutos = dados.compraProdutos();
        }
    }
}
