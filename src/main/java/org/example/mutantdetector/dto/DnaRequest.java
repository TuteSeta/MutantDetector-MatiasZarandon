package org.example.mutantdetector.dto;
import lombok.Getter;
import lombok.Setter;
import org.example.mutantdetector.validations.ValidateDna;

@Getter
@Setter
public class DnaRequest {
    @ValidateDna
    private String[] dna;
}
