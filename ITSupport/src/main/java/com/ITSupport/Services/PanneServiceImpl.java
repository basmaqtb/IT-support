package com.ITSupport.Services;

import com.ITSupport.DTO.PanneDTO;
import com.ITSupport.Models.Equipement;
import com.ITSupport.Models.Panne;
import com.ITSupport.Dao.PanneRepository;
import com.ITSupport.mapper.PanneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanneServiceImpl implements PanneService {

    @Autowired
    private PanneRepository panneRepository;

    @Autowired
    private  PanneMapper panneMapper;

    @Override
    public List<PanneDTO> getAllPannes() {
        return panneMapper.toDto(panneRepository.findAll());
    }

    @Override
    public PanneDTO getPanneById(Long id) {
        Optional<Panne> panne = panneRepository.findById(id);
        return panne.map(panneMapper::toDto).orElse(null);
    }

    @Override
    public PanneDTO createPanne(PanneDTO panneDTO) {
        Panne panne = panneMapper.toEntity(panneDTO);
        panne = panneRepository.save(panne);
        return panneMapper.toDto(panne);
    }

    @Override
    public PanneDTO updatePanne(Long id, PanneDTO panneDTO) {
//        Optional<Panne> optionalPanne = panneRepository.findById(id);
//        if (optionalPanne.isPresent()) {
//            Panne panne = optionalPanne.get();
//            panne.setDescription(panneDTO.getDescription());
//            panne.setDateDetection(panneDTO.getDateDetection());
//            panne.setEtatPannet(panneDTO.getEtatPannet());
//            // Optionally update related entities like tickets and historiques
//            Panne updatedPanne = panneRepository.save(panne);
//            return panneMapper.toDto(updatedPanne);
//        }
        return null;
    }

    @Override
    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }

}
