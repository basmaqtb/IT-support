package com.ITSupport.Dao;

import com.ITSupport.Models.HistoriquePannes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueRepository extends JpaRepository<HistoriquePannes, Long> {
}
