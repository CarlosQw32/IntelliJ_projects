package org.example.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.valueobjects.Telefone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="nome" , length = 150)
    private String nome;

    private String cpf;
    private int idade;
    private int altura;
    private int peso;
    @Embedded
    private Telefone telefone;

    //private Endereco enderco;
}

