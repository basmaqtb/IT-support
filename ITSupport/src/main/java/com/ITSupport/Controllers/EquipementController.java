package com.ITSupport.Controllers;

import com.ITSupport.DTO.EquipementDTO;
import com.ITSupport.Services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    @Autowired
    private EquipementService equipementService;

    // Get all équipements
    @GetMapping("/show")
    public ResponseEntity<List<EquipementDTO>> getAllEquipements() {
        List<EquipementDTO> equipements = equipementService.getAllEquipements();
        return ResponseEntity.ok(equipements);
    }

    // Get an équipement by ID
    @GetMapping("/GetEquipement/{id}")
    public ResponseEntity<EquipementDTO> getEquipementById(@PathVariable Long id) {
        EquipementDTO equipement = equipementService.getEquipementById(id);
        if (equipement != null) {
            return ResponseEntity.ok(equipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new équipement
    @PostMapping("/Add")
    public ResponseEntity<EquipementDTO> createEquipement(@RequestBody EquipementDTO equipementDTO) {
        EquipementDTO createdEquipement = equipementService.createEquipement(equipementDTO);
        return ResponseEntity.status(201).body(createdEquipement);
    }

    // Update an existing équipement
    @PutMapping("/Update/{id}")
    public ResponseEntity<EquipementDTO> updateEquipement(
            @PathVariable Long id,
            @RequestBody EquipementDTO equipementDTO) {
        EquipementDTO updatedEquipement = equipementService.updateEquipement(id, equipementDTO);
        if (updatedEquipement != null) {
            return ResponseEntity.ok(updatedEquipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an équipement
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }
}
