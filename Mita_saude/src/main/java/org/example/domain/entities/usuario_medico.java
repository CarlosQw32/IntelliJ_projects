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
@Table(name = "usuario_medico")
public class usuario_medico {

    @Id
    private long crm_medico;
    private String nome_medico;
    private String senha_medico;
    private String email_medico;
    private String telefone_medico;
}
