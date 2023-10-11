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
@Table(name = "OrderStatusCode")
public class OrderStatusCode {

    @Id
    private int id;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_code_id")
    private Order order;
}
