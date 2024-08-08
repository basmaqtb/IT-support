package com.ITSupport.Services;

import com.ITSupport.DTO.TicketDTO;
import com.ITSupport.Models.Ticket;
import com.ITSupport.Dao.TicketRepository;
import com.ITSupport.Services.Interfaces.TicketService;
import com.ITSupport.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        var ticket= ticketRepository.findById(id).orElse(null);
        var updatedticket = ticketMapper.partialUpdte(ticketDTO, ticket);
        return ticketMapper.toDto(ticketRepository.save(updatedticket));
   }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
