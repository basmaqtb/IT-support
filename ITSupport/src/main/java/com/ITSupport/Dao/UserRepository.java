package com.ITSupport.Dao;

import com.ITSupport.Models.heritage.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
}
