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
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    private int id;

    private int order_id;
    private int product_id;
    private int quantity;
    private float price;



}
