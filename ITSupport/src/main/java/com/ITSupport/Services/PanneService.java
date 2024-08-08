package com.ITSupport.Services;

import com.ITSupport.Models.Panne;

import java.util.List;

public interface PanneService {
    List<Panne> getAllPannes();
    Panne getPanneById(Long id);
    Panne createPanne(Panne panneDTO);
    Panne updatePanne(Long id, Panne panneDTO);
    void deletePanne(Long id);
}
