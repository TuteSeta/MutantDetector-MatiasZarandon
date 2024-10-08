package org.example.mutantdetector.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.mutantdetector.validations.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;

}
