package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Order")
public class Order {

    @Id
    private int id;

    @OneToMany(mappedBy = "Order_id", fetch = FetchType.LAZY)
    private int customer_id;
    private int status_code_id;
    private String customer_comments;
}
