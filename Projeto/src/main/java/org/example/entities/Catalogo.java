package org.example.entities;

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
@Table(name = "Catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String NomeDoAutor;
    private int NumCopias;
}
