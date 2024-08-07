package com.ITSupport.Services;

import com.ITSupport.DTO.PanneDTO;
import com.ITSupport.Models.Panne;
import com.ITSupport.Dao.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanneServiceImpl implements PanneService {

    @Autowired
    private PanneRepository panneRepository;

    @Override
    public List<PanneDTO> getAllPannes() {
        return panneRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PanneDTO getPanneById(Long id) {
        Optional<Panne> panne = panneRepository.findById(id);
        return panne.map(this::convertToDTO).orElse(null);
    }

    @Override
    public PanneDTO createPanne(PanneDTO panneDTO) {
        Panne panne = convertToEntity(panneDTO);
        Panne savedPanne = panneRepository.save(panne);
        return convertToDTO(savedPanne);
    }

    @Override
    public PanneDTO updatePanne(Long id, PanneDTO panneDTO) {
        Panne panne = panneRepository.findById(id).orElse(null);
        if (panne != null) {
            panne.setDescription(panneDTO.getDescription());
            panne.setDateDetection(panneDTO.getDateDetection());
            panne.setEtatPannet(panneDTO.getEtatPannet());
            // Optionally update related entities like tickets and historiques
            Panne updatedPanne = panneRepository.save(panne);
            return convertToDTO(updatedPanne);
        }
        return null;
    }

    @Override
    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }

    private PanneDTO convertToDTO(Panne panne) {
        PanneDTO dto = new PanneDTO();
        dto.setId(panne.getId());
        dto.setDescription(panne.getDescription());
        dto.setDateDetection(panne.getDateDetection());
        dto.setEtatPannet(panne.getEtatPannet());
        dto.setTicketIds(panne.getTickets().stream().map(ticket -> ticket.getId()).collect(Collectors.toList()));
        dto.setHistoriquePanneIds(panne.getHistoriquepannes().stream().map(historique -> historique.getId()).collect(Collectors.toList()));
        return dto;
    }

    private Panne convertToEntity(PanneDTO dto) {
        Panne panne = new Panne();
        panne.setId(dto.getId());
        panne.setDescription(dto.getDescription());
        panne.setDateDetection(dto.getDateDetection());
        panne.setEtatPannet(dto.getEtatPannet());
        // Optionally set related entities like tickets and historiques
        return panne;
    }
}
