package org.example.entities;

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
public class compraRequisicao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idRequisicao;

    private int idProduto;
    //private long cnpjFornecedor;
    private Date dataRequisicao;
    private int quantidadeRequisicao;

    @OneToMany(mappedBy = "compraRequisicao", fetch = FetchType.LAZY)
    private List<compraOrcamento> compraOrcamentos;

    @OneToMany(mappedBy = "compraRequisicao", fetch = FetchType.LAZY)
    private List<compraOrcamento> cnpjFornecedor;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioCliente")
    private compraCliente compraCliente;








}
