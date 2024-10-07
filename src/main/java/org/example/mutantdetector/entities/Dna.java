package org.example.mutantdetector.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADN",columnDefinition = "text", unique = true)
    private String dna;

    private boolean isMutant;

    public void setDna(String[] dna) {
        this.dna = Arrays.toString(dna);
    }

    public String[] getDnaArray() {
        return this.dna.replaceAll("\\[|]|\\s", "").split(",");
    }

}
