package com.ITSupport.Models.heritage;


import com.ITSupport.Models.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Technicien extends Personne {

    @OneToMany(mappedBy = "technicien" , cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
