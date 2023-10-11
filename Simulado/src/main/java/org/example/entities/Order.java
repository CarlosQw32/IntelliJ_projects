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
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int customer_id;
    private int status_code_id;
    private String customer_comments;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderStatusCode> orderStatusCodes;

}
