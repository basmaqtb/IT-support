package com.ITSupport.DTO;

import com.ITSupport.Models.Enums.EtatEquipement;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipementDTO {
    private String type;
    private String marque;
    private String modele;
    private EtatEquipement etat;
}
