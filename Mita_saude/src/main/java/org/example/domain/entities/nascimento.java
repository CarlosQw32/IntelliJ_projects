package org.example.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private long id_nascimeto;

    private double peso_nascimento;
    private double altura_nascimento;
    private Date data_nascimento;
    private double hora_nascimento;
    private boolean teste_pezinho_nascimento;
    private String local_nascimento;



}
