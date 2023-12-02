package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

}
