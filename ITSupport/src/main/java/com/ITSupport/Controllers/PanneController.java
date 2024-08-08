package com.ITSupport.Controllers;

import com.ITSupport.Models.Panne;
import com.ITSupport.Services.PanneService;
import com.ITSupport.Services.PanneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/pannes")
public class PanneController {

    @Autowired
    private PanneServiceImpl panneService;

    @GetMapping("/show")
    public ResponseEntity<List<Panne>> getAllPannes() {
        List<Panne> pannes = panneService.getAllPannes();
        return ResponseEntity.ok(pannes);
    }

    @GetMapping("/GetPanne/{id}")
    public ResponseEntity<Panne> getPanneById(@PathVariable Long id) {
        Panne panne = panneService.getPanneById(id);
        return panne != null ? ResponseEntity.ok(panne) : ResponseEntity.notFound().build();
    }

    @PostMapping("/Add")
    public Panne createPanne(@RequestBody Panne panneDTO) {
       // Panne createdPanne = panneService.createPanne(panneDTO);
        //return ResponseEntity.status(201).body(createdPanne);
        return panneService.createPanne(panneDTO);
    }

//    @PutMapping("/Update/{id}")
//    public ResponseEntity<PanneDTO> updatePanne(@PathVariable Long id, @RequestBody PanneDTO panneDTO) {
//        PanneDTO updatedPanne = panneService.updatePanne(id, panneDTO);
//        return updatedPanne != null ? ResponseEntity.ok(updatedPanne) : ResponseEntity.notFound().build();
//    }

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
