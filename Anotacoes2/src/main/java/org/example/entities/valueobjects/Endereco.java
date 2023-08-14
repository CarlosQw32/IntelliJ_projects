package org.example.entities.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class Endereco {

    @Column (name = "endereco_logradouro")
    private String logradouro;
    @Column (name = "endereco_numero")
    private String numero;
    @Column (name = "")
    private String complemento;

    private String cep;

    private String bairro;

    private String cidade;

}
