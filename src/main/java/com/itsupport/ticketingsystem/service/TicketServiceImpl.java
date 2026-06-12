package com.itsupport.ticketingsystem.service;

import com.itsupport.ticketingsystem.entity.Ticket;
import com.itsupport.ticketingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Tells Spring this is our business logic layer
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        // We handle the "Optional" logic here in the service now
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return ticket.get();
        } else {
            throw new RuntimeException("Ticket not found with id: " + id);
        }
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        // Business Logic: All new tickets must start as OPEN
        ticket.setStatus("OPEN");
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicketStatus(Long id, String status) {
        Ticket existingTicket = getTicketById(id); // Reuses the method above
        existingTicket.setStatus(status);
        return ticketRepository.save(existingTicket);
    }
}