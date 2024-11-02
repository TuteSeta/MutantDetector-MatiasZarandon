package org.example.mutantdetector.services;
import org.example.mutantdetector.dto.DnaRequest;
import org.example.mutantdetector.repositories.DnaRepository;
import org.example.mutantdetector.validations.DnaValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TestDnaService {
    @Autowired
    private DnaService dnaService;

    @MockBean
    private DnaValidator dnaValidator;

    @MockBean
    private DnaRepository dnaRepository;
    // Tests matriz 6x6
    @Test
    public void testRows() {
        String[] dnaString = {
                "AAAATG",
                "TGCAGT",
                "GCTTCC",
                "CCCCTG",
                "GTAGTC",
                "AGTCAC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testColumns() {
        String[] dnaString = {
                "AGAATG",
                "TGCAGT",
                "GCTTCC",
                "GTCCTC",
                "GTAGTC",
                "GGTCAC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }


    @Test
    public void testLeftToRightDiagonals() {
        String[] dnaString = {
                "ATAATG",
                "GTTAGT",
                "GGCTCG",
                "TTGATG",
                "GTAGTC",
                "AGTCAA"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testRightToLeftDiagonals() {
        String[] dnaString = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }


    // ====================================================================================================
    //Tests varios
    @Test
    public void testNonMutant() {
        String[] dnaString = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertFalse(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testMutant() {
        String[] dnaString = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testMutantHomogenous() {
        String[] dnaString = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testOtherNonMutant() {
        String[] dnaString = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertFalse(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testMutantLarge() {
        String[] dnaString = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }

    @Test
    public void testMutantXLarge() {
        String[] dnaString = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };
        DnaRequest dna = new DnaRequest();
        dna.setDna(dnaString);
        assertTrue(dnaService.isMutant(dna.getDna()));
    }
}
