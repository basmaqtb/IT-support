package com.ITSupport.Services.Interfaces;

import com.ITSupport.DTO.TicketDTO;
import com.ITSupport.Models.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    public List<Ticket> getAllTickets() ;

    public Optional<Ticket> getTicketById(Long id) ;

    public Ticket createTicket(Ticket ticket) ;

    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) ;

    public void deleteTicket(Long id) ;
}
