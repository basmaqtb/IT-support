package com.ITSupport.mapper;

import com.ITSupport.DTO.EquipementDTO;
import com.ITSupport.Models.Equipement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EquipementMapper {
    //EquipementMapper INSTANCE = Mappers.getMapper(EquipementMapper.class);

    EquipementDTO toDto(Equipement equipement);
    Equipement toEntity(EquipementDTO dto);
    List<Equipement> toEntity(List<EquipementDTO> list);
    List<EquipementDTO> toDto(List<Equipement> list);
    Equipement partialUpdate(EquipementDTO equipementDTO, @MappingTarget Equipement equipement);
}
