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
@Table(name = "obito")
public class obito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_obito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name =  "cpf_crian")
    private usuario_crianca crianca;

    private String causa_obito;
    private String local_obito;
    private Date data_obito;
    private double hora_obito;
}
