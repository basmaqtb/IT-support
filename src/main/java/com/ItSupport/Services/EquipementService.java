package com.ItSupport.Services;

import com.ItSupport.Dao.EquipementRepository;
import com.ItSupport.Models.Equipement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    public List<Equipement> getAllEquipement(){
        return equipementRepository.findAll();
    }

    public Equipement addEquipement(Equipement equipement){
        return equipementRepository.save(equipement);
    }

    public Optional<Equipement> getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    public Equipement updateEquipement(Long id, Equipement updatedEquipement) {
        return equipementRepository.findById(id)
                .map(equipement -> {
                    equipement.setType(updatedEquipement.getType());
                    equipement.setMarque(updatedEquipement.getMarque());
                    equipement.setModele(updatedEquipement.getModele());
                    equipement.setEtat(updatedEquipement.getEtat());

                    return equipementRepository.save(equipement);
                })
                .orElseThrow(() -> new RuntimeException("Équipement non trouvé avec ID : " + id));
    }

    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
