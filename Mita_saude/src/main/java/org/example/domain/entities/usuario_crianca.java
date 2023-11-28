package org.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuario_crianca")
public class usuario_crianca {

    @Id
    private Long cpf_crian;

    private String nome_crian;
    private String condicies_preexistentes_crian;
    private String comunidade_crian;
    private String etinia_crian;
}
