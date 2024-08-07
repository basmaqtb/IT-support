package com.ITSupport.mapper;

import com.ITSupport.DTO.EquipementDTO;
import com.ITSupport.Models.Equipement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipementMapper {

    Equipement toEntitty(EquipementDTO equipementDTO);
    EquipementDTO toDto(Equipement equipement);
    List<Equipement> toEntity(List<EquipementDTO> list);
    List<EquipementDTO> toDto(List<Equipement> list);

}
