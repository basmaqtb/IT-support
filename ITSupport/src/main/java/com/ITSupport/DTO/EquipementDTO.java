package com.ITSupport.DTO;

import com.ITSupport.Models.EtatEquipement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class EquipementDTO implements Serializable {
    private Long id;
    private String type;
    private String marque;
    private String modele;
    private EtatEquipement etat;
}
