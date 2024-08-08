package com.ITSupport.mapper;


import com.ITSupport.DTO.TicketDTO;
import com.ITSupport.Models.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    Ticket toEntity(TicketDTO ticketDTO);
    TicketDTO toDto(Ticket ticket);
    List<Ticket> toEntity(List<TicketDTO> ticketDTOS);
    List<TicketDTO> toDto(List<Ticket> tickets);
    Ticket partialUpdte(TicketDTO ticketDTO, @MappingTarget Ticket ticket);
}
