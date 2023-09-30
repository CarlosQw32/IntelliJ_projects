package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Track")
public class Track extends BaseEntity {

    @Column(length = 50)

    private String track_name;
    private int track_length;
    private int track_size;
    private int track_price;
    private String track_language;
    private String track_producer;
    private String track_songwriters;
    private String track_released;

    public Track(String track_name, int track_length, int track_size, int track_price, String track_language, String track_producer, String track_songwriters, String track_released) {
        this.track_name = track_name;
        this.track_length = track_length;
        this.track_size = track_size;
        this.track_price = track_price;
        this.track_language = track_language;
        this.track_producer = track_producer;
        this.track_songwriters = track_songwriters;
        this.track_released = track_released;
    }

    @OneToMany(mappedBy = "track", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Purchase> purchase;

    @ManyToMany(mappedBy = "tracks", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Genre> genres;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(mappedBy = "collaborations",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Artist> colaborations = new ArrayList<>();

    @ManyToMany(mappedBy = "tracks",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Album> albuns;
}
