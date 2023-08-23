package org.example.entities.pessoa;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "estudantes")
//@DiscriminatorValue("1")
public class Estudante extends Pessoa {
    private int numeroEstudante;
    private Double mediaGeral;
}
