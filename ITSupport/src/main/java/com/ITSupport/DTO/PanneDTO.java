package com.ITSupport.DTO;

import com.ITSupport.Models.Enums.EtatPanne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
public class PanneDTO implements Serializable {
    private Long id;
    private String description;
    private Date dateDetection;
    private EtatPanne etatPannet;
    private List<Long> ticketIds;
}
