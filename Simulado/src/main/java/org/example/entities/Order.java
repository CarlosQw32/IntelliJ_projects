package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.base.BaseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Order_Pedido")
public class Order extends BaseEntity {


    private int customer_id;
    private int status_code_id;
    private String customer_comments;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderStatusCode> orderStatusCodes;

}
