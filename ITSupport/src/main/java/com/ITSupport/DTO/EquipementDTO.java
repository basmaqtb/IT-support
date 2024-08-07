package com.ITSupport.DTO;

import com.ITSupport.Models.EtatEquipement;
import lombok.Data;

import java.io.Serializable;

@Data
public class EquipementDTO implements Serializable {
    private Long id;
    private String type;
    private String marque;
    private String modele;
    private EtatEquipement etat; // Assuming EtatEquipement is also used in DTO
}
