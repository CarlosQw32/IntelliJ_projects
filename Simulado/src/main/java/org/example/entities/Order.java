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
@Table(name = "Order_Pedido")
public class Order {

    @Id
    private int id;

    private int customer_id;


    private int status_code_id;

    private String customer_comments;
}
