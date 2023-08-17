package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table (name = "estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numeroEstudante;
    private Double mediaGeral;

    @OneToMany(mappedBy = "estudante", orphanRemoval = true)
    private List<Endereco> enderecos;
}
