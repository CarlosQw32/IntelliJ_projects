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
@Table(name = "Record_label")
public class Record_Label extends BaseEntity {


    private String record_label_Name;
    private String website;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private List<Album> album;
}
