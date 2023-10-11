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
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private int product_id;
    private int quantity;
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;


}
