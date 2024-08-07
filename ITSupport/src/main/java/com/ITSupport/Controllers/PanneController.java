package com.ITSupport.Controllers;

import com.ITSupport.DTO.PanneDTO;
import com.ITSupport.Services.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/pannes")
public class PanneController {

    @Autowired
    private PanneService panneService;

    @GetMapping("/show")
    public ResponseEntity<List<PanneDTO>> getAllPannes() {
        List<PanneDTO> pannes = panneService.getAllPannes();
        return ResponseEntity.ok(pannes);
    }

    @GetMapping("/GetPanne/{id}")
    public ResponseEntity<PanneDTO> getPanneById(@PathVariable Long id) {
        PanneDTO panne = panneService.getPanneById(id);
        return panne != null ? ResponseEntity.ok(panne) : ResponseEntity.notFound().build();
    }

    @PostMapping("/Add")
    public ResponseEntity<PanneDTO> createPanne(@RequestBody PanneDTO panneDTO) {
        PanneDTO createdPanne = panneService.createPanne(panneDTO);
        return ResponseEntity.status(201).body(createdPanne);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<PanneDTO> updatePanne(@PathVariable Long id, @RequestBody PanneDTO panneDTO) {
        PanneDTO updatedPanne = panneService.updatePanne(id, panneDTO);
        return updatedPanne != null ? ResponseEntity.ok(updatedPanne) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        if (panneService.getPanneById(id) != null) {
            panneService.deletePanne(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
