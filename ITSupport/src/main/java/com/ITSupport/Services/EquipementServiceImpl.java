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

    @Autowired(required = true)
    private EquipementRepository equipementRepository;

    @Autowired(required = true)
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
        var equipment = equipementRepository.findById(id).orElse(null);
        var updatedEquipment = equipementMapper.partialUpdate(equipementDTO, equipment);
        return equipementMapper.toDto(equipementRepository.save(updatedEquipment));
}

    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}
