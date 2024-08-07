package com.ITSupport.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Technicien extends Personne {


    @OneToMany(mappedBy = "technicien" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
