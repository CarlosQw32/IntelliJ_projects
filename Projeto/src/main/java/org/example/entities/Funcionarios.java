package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Funcionarios")

public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private String Id;
    private String Senha;

    @OneToMany
    @JoinColumn(name = "livro_Id")
    private List<Livro> livro;
}
