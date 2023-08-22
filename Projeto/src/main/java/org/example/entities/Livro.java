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
@Table(name = "livro")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String NomeLivro;
    private String NomeAutor;
    private int NumLivros;
    private String Codigo;
    private String Assunto;

    @ManyToOne
    @JoinColumn (name= "Funcionarios_Id")
    private Funcionarios funcionarios;

    @ManyToMany
    @JoinColumn (name = "Catalogo_Id")
    private List<Catalogo> catalogo;

    @OneToOne
    @JoinColumn (name = "Clinete_Id")
    private  Cliente cliente;





}
