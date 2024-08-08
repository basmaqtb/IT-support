package com.ITSupport.Models.heritage;

import com.ITSupport.Models.Ticket;
import jakarta.persistence.CascadeType;
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

