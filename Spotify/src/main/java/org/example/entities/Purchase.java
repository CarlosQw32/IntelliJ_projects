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
@Table(name = "Purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private String payment_method;
    private String date_purchase;
    private String time_purchase;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "track_id")
    private Track track;

}
