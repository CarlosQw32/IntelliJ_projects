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
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int album_id;
    private String album_name;
    private String album_type;
    private String album_released;
    private String album_recorded;
}
