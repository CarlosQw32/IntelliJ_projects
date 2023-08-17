package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.Endereco;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int salario;
    private int numeroFuncionario;
    private int anosServico;
    private int numroClasse;

    @OneToMany(mappedBy = "professor", orphanRemoval = true)
    private List<Endereco> enderecos;



}
