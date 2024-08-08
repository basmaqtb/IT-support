package com.ITSupport.DTO;

import com.ITSupport.Models.Enums.StatutTicket;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
public class TicketDTO implements Serializable {
    private Long id;
    private String description;
    private Date dateCreation;
    private StatutTicket statut;
    private Long technicienId;
    private String technicienNom;
    private Long utilisateurId;
    private String utilisateurNom;
    private Long panneId;
    private String panneDescription;
    private Long equipementId;
    private String equipementNom;
}
