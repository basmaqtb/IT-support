package com.ITSupport.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private StatutTicket statut;

    @ManyToOne
    private Technicien technicien;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Panne panne;

    @ManyToOne
    private Equipement equipement;
}
