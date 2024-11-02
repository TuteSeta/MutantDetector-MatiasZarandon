package org.example.mutantdetector.services;
import org.example.mutantdetector.entities.Dna;
import org.example.mutantdetector.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DnaService {

    private final DnaRepository dnaRepository;
    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean isMutant(String[] dna) {

        int sequenceCount = 0; // Contador de secuencias encontradas
        int size = dna.length;

        // Verificar horizontal, vertical y diagonal usando métodos separados
        sequenceCount += checkAllHorizontal(dna,size);
        sequenceCount += checkAllVertical(dna,size);
        sequenceCount += checkAllDiagonals(dna,size);

        // Es mutante si encuentra más de una secuencia
        return sequenceCount > 1;
    }

    //Chequea Diagonales de izquierda a derecha
    private int checkAllHorizontal(String[] dna, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += checkSequence(dna[i]);
        }
        return count;
    }

    //Chequea Verticales
    private int checkAllVertical(String[] dna, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            StringBuilder column = new StringBuilder();
            for (int i = 0; i < size; i++) {
                column.append(dna[i].charAt(j));
            }
            count += checkSequence(column.toString());
        }
        return count;
    }

    private int checkAllDiagonals(String[] dna, int size) {
        int count = 0;

        // Diagonales de izquierda a derecha (↘)
        for (int start = 0; start < size * 2 - 1; start++) {
            StringBuilder diagonal = new StringBuilder();
            for (int row = 0; row <= start; row++) {
                int col = start - row;
                if (row < size && col < size) {
                    diagonal.append(dna[row].charAt(col));
                }
            }
            count += checkSequence(diagonal.toString());
        }

        // Diagonales de derecha a izquierda (↙)
        for (int start = 1 - size; start < size; start++) {
            StringBuilder diagonal = new StringBuilder();
            for (int row = 0; row < size; row++) {
                int col = row - start;
                if (col >= 0 && col < size) {
                    diagonal.append(dna[row].charAt(col));
                }
            }
            count += checkSequence(diagonal.toString());
        }

        return count;
    }

    private int checkSequence(String sequence) {
        int count = 0;
        char currentChar = sequence.charAt(0);
        int currentStreak = 1;

        // Contar secuencias de 4 caracteres iguales
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentChar) {
                currentStreak++;
                if (currentStreak == 4) {
                    count++;
                    currentStreak = 0; // Reiniciar para contar otras secuencias
                }
            } else {
                currentChar = sequence.charAt(i);
                currentStreak = 1;
            }
        }

        return count;
    }

    public boolean saveDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        // Verificar si ya existe un registro con este ADN
        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);
        // Si ya existe, no guardar de nuevo
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Verificamos si es mutante y guardamos
        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder()
                .dna(dnaSequence)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);

        return isMutant(dna);
    }
}
