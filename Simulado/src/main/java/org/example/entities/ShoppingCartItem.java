package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.base.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "ShoppingCartItem")
public class ShoppingCartItem extends BaseEntity {


    private String customer_id;
    private int product_id;
    private int quantity;
    private float price;


}
