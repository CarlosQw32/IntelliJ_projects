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
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "genre_Id", nullable = false)
    private int genre_Id;
    private String genre_name;

    @OneToMany(mappedBy = "genre")
    private List<Genre_Track> genre_tracks;

}
