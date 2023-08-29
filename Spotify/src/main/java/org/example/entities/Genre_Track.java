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
@Table(name = "Genre_Track")
public class Genre_Track {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @ManyToOne
    @JoinColumn(name = "genre_Id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;


}
