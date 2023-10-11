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

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_code_id")*/
    private String status_code;

    private String description;


}
