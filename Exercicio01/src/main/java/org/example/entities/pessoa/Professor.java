package org.example.entities.pessoa;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "professores")
//@DiscriminatorValue("2")
public class Professor extends Pessoa{
    private double salary;
    private int yearsOfService;
    private int staffNumber;
    private int numberOfClasses;
}
