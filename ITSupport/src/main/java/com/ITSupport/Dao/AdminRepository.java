package com.ITSupport.Dao;

import com.ITSupport.Models.heritage.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
