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
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "artist_id", nullable = false)
    private int artist_id;
    private String artist_name;
    private String artist_type;

    @OneToMany(mappedBy = "artist")
    private List<Album> album;

    @OneToMany(mappedBy = "artist")
    private List<Track_Artist> track_artists;




}
