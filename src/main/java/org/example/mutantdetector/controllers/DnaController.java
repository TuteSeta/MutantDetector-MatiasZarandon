package org.example.mutantdetector.controllers;

import jakarta.validation.Valid;
import org.example.mutantdetector.dto.DnaRequest;
import org.example.mutantdetector.dto.DnaResponse;
import org.example.mutantdetector.services.DnaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")
public class DnaController {

    private final DnaService dnaService;

    public DnaController(DnaService dnaService) {
        this.dnaService = dnaService;
    }
    @PostMapping("")
    public ResponseEntity<DnaResponse> checkMutant(@RequestBody @Valid DnaRequest dnaRequest) {
        boolean isMutant = dnaService.saveDna(dnaRequest.getDna());
        DnaResponse dnaResponse = new DnaResponse(isMutant);
        if (isMutant) {
            return ResponseEntity.ok(dnaResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dnaResponse);
        }
    }
}
