package org.example.mutantdetector.entities;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dna extends Base implements Serializable {

    @Column(name = "ADN",columnDefinition = "text", unique = true)
    private String dna;

    private boolean isMutant;

}
