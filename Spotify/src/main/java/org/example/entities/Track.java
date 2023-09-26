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
@Table(name = "Track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "track_id", nullable = false)
    private int track_id;
    private String track_name;
    private String track_lenght;
    private double track_size;
    private double  track_price;
    private String track_languege;
    private String track_producer;
    private String track_songwriters;
    private String track_released;

    @OneToMany (mappedBy = "track")
    private List<Purchase> purchases;

    @OneToMany (mappedBy = "track")
    private List<Genre_Track> genre_tracks;



    @OneToMany (mappedBy = "track")
    private List<Track_Artist> track_artists;
}
