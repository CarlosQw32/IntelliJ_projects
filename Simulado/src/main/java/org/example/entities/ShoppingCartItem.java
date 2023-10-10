package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "ShoppingCartItem")
public class ShoppingCartItem {

    private int id;
    private String customer_id;
    private int product_id;
    private int quantity;
    private float price;


}
