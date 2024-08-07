package com.ITSupport.Services;

import com.ITSupport.DTO.PanneDTO;

import java.util.List;

public interface PanneService {
    List<PanneDTO> getAllPannes();
    PanneDTO getPanneById(Long id);
    PanneDTO createPanne(PanneDTO panneDTO);
    PanneDTO updatePanne(Long id, PanneDTO panneDTO);
    void deletePanne(Long id);
}
