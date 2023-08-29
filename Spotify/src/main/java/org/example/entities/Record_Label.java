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
@Table(name = "Record_label")
public class Record_Label {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "record_Label_Id", nullable = false)
    private double record_Label_Id;
    private String record_label_Name;
    private String website;

    @OneToMany(mappedBy = "record_label")
    private List<Album> album;
}
