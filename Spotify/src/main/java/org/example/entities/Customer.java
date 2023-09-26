package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.valueObjects.CardInformation;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer {


    @Id
    @Column(length = 50)
    private String email;

    private String name;
    private String password;
    private int age;
    @Embedded
    private CardInformation card_information;
    private double ip_address;
    private String device;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Purchase> purchase;
}
