package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.entities.base.BaseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {



        private String genre_name;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "genre_track",
                joinColumns = @JoinColumn(name = "genre_id"),
                inverseJoinColumns = @JoinColumn(name="track_id")
        )
        private List<Track> tracks;

}
