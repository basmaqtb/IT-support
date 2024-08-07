package com.ITSupport.Services;

import com.ITSupport.DTO.EquipementDTO;
import com.ITSupport.Models.Equipement;
import com.ITSupport.Dao.EquipementRepository;
import com.ITSupport.mapper.EquipementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @Autowired
    private EquipementMapper equipementMapper;

    @Override
    public List<EquipementDTO> getAllEquipements() {
        return equipementMapper.toDto(equipementRepository.findAll());
    }

    @Override
    public EquipementDTO getEquipementById(Long id) {
        Optional<Equipement> equipement = equipementRepository.findById(id);
        return equipement.map(equipementMapper::toDto).orElse(null);
    }

    @Override
    public EquipementDTO createEquipement(EquipementDTO equipementDTO) {
        Equipement equipement = equipementMapper.toEntity(equipementDTO);
        Equipement savedEquipement = equipementRepository.save(equipement);
        return equipementMapper.toDto(savedEquipement);
    }

    @Override
    public EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO) {
        Optional<Equipement> optionalEquipement = equipementRepository.findById(id);
        if (optionalEquipement.isPresent()) {
            Equipement equipement = optionalEquipement.get();
            equipement.setType(equipementDTO.getType());
            equipement.setMarque(equipementDTO.getMarque());
            equipement.setModele(equipementDTO.getModele());
            equipement.setEtat(equipementDTO.getEtat());
            Equipement updatedEquipement = equipementRepository.save(equipement);
            return equipementMapper.toDto(updatedEquipement);
        }
        return null;
    }

    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
