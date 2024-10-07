package org.example.mutantdetector.repositories;

import org.example.mutantdetector.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
    Optional<Dna> findByDna(String dna);
    long countByIsMutant(boolean isMutant);
}