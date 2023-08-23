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
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int artist_id;
    private String artist_name;
    private String artist_type;
}
