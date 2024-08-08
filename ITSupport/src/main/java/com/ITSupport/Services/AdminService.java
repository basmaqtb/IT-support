package com.ITSupport.Services;

import com.ITSupport.Models.heritage.Admin;
import com.ITSupport.Dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

//    public Admin updateAdmin(Long id, Admin adminDetails) {
//        Admin admin = adminRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Admin not found"));
//        admin.setNom(adminDetails.getNom());
//        admin.setEmail(adminDetails.getEmail());
//        admin.setMotDePasse(adminDetails.getMotDePasse());
//        return adminRepository.save(admin);
//    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
