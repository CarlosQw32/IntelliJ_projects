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
@Table(name = "Track_Artist")
public class Track_Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    @ManyToOne
    @JoinColumn (name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn (name = "Featuring_artist_id")
    private Artist Featuring_artist_id;


}
