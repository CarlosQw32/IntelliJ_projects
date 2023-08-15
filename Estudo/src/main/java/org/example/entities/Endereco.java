package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.Estudante;
import org.example.entities.Professor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public String rua;
    public String cidade;
    public String estado;
    public int cep;
    public String pais;

    @ManyToOne
    @JoinColumn(name= "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
