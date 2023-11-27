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
@ToString
@Entity
@Table(name = "OrderStatusCode")
public class OrderStatusCode extends BaseEntity {



    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_code_id")
    private Order order;
}
