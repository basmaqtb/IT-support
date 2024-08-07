package com.ITSupport.Services;

import com.ITSupport.DTO.EquipementDTO;

import java.util.List;

public interface EquipementService {

        // Method to get all equipements, returning a list of EquipementDTO
        List<EquipementDTO> getAllEquipements();

        // Method to get a specific equipement by ID, returning EquipementDTO
        EquipementDTO getEquipementById(Long id);

        // Method to create a new equipement, accepting EquipementDTO and returning EquipementDTO
        EquipementDTO createEquipement(EquipementDTO equipementDTO);

        // Method to update an existing equipement, accepting ID and EquipementDTO, returning EquipementDTO
        EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO);

        // Method to delete an equipement by ID
        void deleteEquipement(Long id);
}
