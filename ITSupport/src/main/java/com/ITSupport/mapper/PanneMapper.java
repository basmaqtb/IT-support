package com.ITSupport.mapper;

import com.ITSupport.DTO.EquipementDTO;
import com.ITSupport.DTO.PanneDTO;
import com.ITSupport.Models.Equipement;
import com.ITSupport.Models.Panne;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PanneMapper {

    Panne toEntity(PanneDTO panneDTO);
    PanneDTO toDto(Panne panne);
    List<Panne> toEntity(List<PanneDTO> panneDTOS);
    List<PanneDTO> toDto(List<Panne> pannes);
    Panne partialUpdate(PanneDTO panneDTO, @MappingTarget Panne panne);

}
