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
@Table(name = "Record_label")
public class Record_Label {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private double record_Label_Id;
    private String record_label_Name;
    private String website;
}
