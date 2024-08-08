package com.ITSupport.Services;

import com.ITSupport.Models.Panne;
import com.ITSupport.Dao.PanneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneServiceImpl implements PanneService {

    @Autowired
    private PanneRepository panneRepository;

//    @Autowired
//    private  PanneMapper panneMapper;

    @Override
    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    @Override
    public Panne getPanneById(Long id) {

        return null;
    }

    @Override
    public Panne createPanne(Panne panneDTO) {
//        Panne panne = panneMapper.toEntity(panneDTO);
//        panne = panneRepository.save(panne);
//        return panneMapper.toDto(panne);
        return panneRepository.save(panneDTO);
    }

    @Override
    public Panne updatePanne(Long id, Panne panneDTO) {
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
