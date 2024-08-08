package com.ITSupport.Controllers;

import com.ITSupport.DTO.PanneDTO;
import com.ITSupport.DTO.TicketDTO;
import com.ITSupport.Models.Ticket;
import com.ITSupport.Services.Interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("http://localhost:8081/")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/show")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/GetPanne/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Add")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        TicketDTO updatedticket = ticketService.updateTicket(id, ticketDTO);
        return updatedticket != null ? ResponseEntity.ok(updatedticket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        if (ticketService.getTicketById(id) != null) {
           ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
