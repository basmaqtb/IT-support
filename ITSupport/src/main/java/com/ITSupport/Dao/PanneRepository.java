package com.ITSupport.Dao;

import com.ITSupport.Models.Equipement;
import com.ITSupport.Models.Panne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanneRepository extends JpaRepository<Panne, Long> {
}
