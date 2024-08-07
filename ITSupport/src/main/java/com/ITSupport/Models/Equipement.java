package com.ITSupport.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Data;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private EtatEquipement etat;


    @OneToMany(mappedBy = "equipement", cascade = CascadeType.ALL)
    private List<HistoriquePannes> Historiquepannes;

    @OneToMany(mappedBy = "equipement", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
