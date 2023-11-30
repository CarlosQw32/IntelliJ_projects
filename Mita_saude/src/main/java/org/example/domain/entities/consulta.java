package org.example.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "consulta")
public class consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_consulta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private usuario_crianca crianca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crm_medico")
    private usuario_medico medico;

    private String mes_1_consulta;
    private String mes_2_consulta;
    private String mes_3_consulta;
    private String mes_4_consulta;
    private String mes_5_consulta;
    private String mes_6_consulta;
    private String mes_7_consulta;
    private String mes_8_consulta;
    private String mes_9_consulta;
    private String mes_10_consulta;
    private String mes_11_consulta;
    private String mes_12_consulta;
    private String mes_13_consulta;
    private String mes_14_consulta;
    private String mes_15_consulta;
    private String mes_16_consulta;
    private String mes_17_consulta;
    private String mes_18_consulta;
    private String mes_19_consulta;
    private String mes_20_consulta;
    private String mes_21_consulta;
    private String mes_22_consulta;
    private String mes_23_consulta;
    private String mes_24_consulta;
}
