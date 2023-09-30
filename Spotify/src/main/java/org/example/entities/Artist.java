package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.base.BaseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Artist")
public class Artist extends BaseEntity {


    private String artist_name;
    private String artist_type;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Track> tracks = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinTable(
            name = "artist_track",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private List<Track> collaborations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Album> album;




}
