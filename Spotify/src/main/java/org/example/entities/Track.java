package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Track")
public class Track {

    private int track_id;
    private String track_name;
    private String track_lenght;
    private double track_size;
    private double  track_price;
    private String track_languege;
    private String track_producer;
    private String track_songwriters;
    private String track_released;

}
