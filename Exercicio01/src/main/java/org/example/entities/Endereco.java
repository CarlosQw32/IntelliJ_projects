package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.entities.enums.Estados;
import org.example.entities.pessoa.Pessoa;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "Enderecos")
public class Endereco extends BaseEntity{
    private String street;
    private String number;
    private String city;
    @Column(length = 8)
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Estados district;
    private String country;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
