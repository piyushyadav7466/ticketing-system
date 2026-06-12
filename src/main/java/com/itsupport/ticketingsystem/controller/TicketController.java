package com.itsupport.ticketingsystem.controller;

import com.itsupport.ticketingsystem.entity.Ticket;
import com.itsupport.ticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    // 1. Swap the Repository for the Service
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        try {
            Ticket ticket = ticketService.getTicketById(id);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateTicketStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        try {
            Ticket updatedTicket = ticketService.updateTicketStatus(id, status);
            return ResponseEntity.ok(updatedTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}