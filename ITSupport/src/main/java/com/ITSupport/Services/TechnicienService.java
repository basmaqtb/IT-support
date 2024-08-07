package com.ITSupport.Services;

import com.ITSupport.Models.Technicien;
import com.ITSupport.Dao.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicienService {

    @Autowired
    private TechnicienRepository technicienRepository;

    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    public Optional<Technicien> getTechnicienById(Long id) {
        return technicienRepository.findById(id);
    }

    public Technicien createTechnicien(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    public Technicien updateTechnicien(Long id, Technicien technicienDetails) {
        Technicien technicien = technicienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technicien not found"));
        technicien.setNom(technicienDetails.getNom());
        technicien.setEmail(technicienDetails.getEmail());
        technicien.setMotDePasse(technicienDetails.getMotDePasse());
        technicien.setTickets(technicienDetails.getTickets());
        return technicienRepository.save(technicien);
    }

    public void deleteTechnicien(Long id) {
        technicienRepository.deleteById(id);
    }
}
