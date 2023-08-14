package org.example.entities.valueobjects;

import jakarta.persistence.Column;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Enabled

public class Telefone {
    @Column (name = "telefone_ddd")
    private String ddd;
    @Column (name = "telefone_numero")
    private String numero;
}
