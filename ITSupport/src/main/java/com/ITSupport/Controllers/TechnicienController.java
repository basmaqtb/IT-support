package com.ITSupport.Controllers;

import com.ITSupport.Models.Technicien;
import com.ITSupport.Services.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/techniciens")
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;

    @GetMapping
    public List<Technicien> getAllTechniciens() {
        return technicienService.getAllTechniciens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technicien> getTechnicienById(@PathVariable Long id) {
        Optional<Technicien> technicien = technicienService.getTechnicienById(id);
        return technicien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Technicien createTechnicien(@RequestBody Technicien technicien) {
        return technicienService.createTechnicien(technicien);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Technicien> updateTechnicien(@PathVariable Long id, @RequestBody Technicien technicienDetails) {
//        Optional<Technicien> technicien = technicienService.getTechnicienById(id);
//        if (technicien.isPresent()) {
//            return ResponseEntity.ok(technicienService.updateTechnicien(id, technicienDetails));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnicien(@PathVariable Long id) {
        Optional<Technicien> technicien = technicienService.getTechnicienById(id);
        if (technicien.isPresent()) {
            technicienService.deleteTechnicien(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
