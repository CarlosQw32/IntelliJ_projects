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
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "album_id", nullable = false)
    private int album_id;
    private String album_name;
    private String album_type;
    private String album_released;
    private String album_recorded;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "record_Label_Id")
    private Record_Label record_label;

    @OneToMany(mappedBy = "album")
    private List<Album_Track> album_tracks;

}
