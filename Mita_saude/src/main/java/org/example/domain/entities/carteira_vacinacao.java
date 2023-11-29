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
@Table(name = "carteira_vacinacao")
public class carteira_vacinacao {

    @Id
    private long id_carteira_vacina;

    private String vacina_ao_nascer;
    private String vacina_mes_1;
    private String vacina_mes_2;
    private String vacina_mes_4;
    private String vacina_mes_6;
    private String vacina_mes_9;
    private String vacina_mes_12;
    private String vacina_mes_15;
}
