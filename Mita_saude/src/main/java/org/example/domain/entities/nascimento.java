package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nascimento")
public class nascimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_nascimeto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private usuario_crianca crianca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crm_medico")
    private usuario_medico medico;

    private double peso_nascimento;
    private double altura_nascimento;
    private Date data_nascimento;
    private double hora_nascimento;
    private boolean teste_pezinho_nascimento;
    private String local_nascimento;



}
