package org.example.entities.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.BaseEntity;
import org.example.entities.Endereco;
import org.example.entities.pessoa.valueObjects.Telefone;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Pessoas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa extends BaseEntity {
    private String nome;
    @Embedded
    private Telefone telefone;
    private String email;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true)
    private List<Endereco> enderecos;
}
