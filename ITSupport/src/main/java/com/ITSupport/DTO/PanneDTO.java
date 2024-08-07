package com.ITSupport.DTO;

import com.ITSupport.Models.EtatPanne;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PanneDTO implements Serializable {
    private Long id;
    private String description;
    private Date dateDetection;
    private EtatPanne etatPannet;
    private List<Long> ticketIds; // IDs of tickets related to the panne
    private List<Long> historiquePanneIds; // IDs of historiques related to the panne
}
