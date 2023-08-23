package org.example.entities.pessoa.valueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Telefone {

    @Column(name="telefone_ddd", length = 2)
    private String DDD;
    @Column(name = "telefone_numero", length = 9)
    private String numero;
}
