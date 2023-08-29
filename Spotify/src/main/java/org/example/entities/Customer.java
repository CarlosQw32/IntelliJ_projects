package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "email", nullable = false)
    private String email;
    private String name;
    private String password;
    private int age;
    private double card_information;
    private double ip_address;
    private String device;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

}
