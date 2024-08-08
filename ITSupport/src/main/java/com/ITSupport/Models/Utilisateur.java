package com.ITSupport.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor

public class Utilisateur extends Personne {

    @OneToMany(mappedBy = "utilisateur" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}

