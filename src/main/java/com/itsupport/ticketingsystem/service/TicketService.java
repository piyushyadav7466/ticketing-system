package com.itsupport.ticketingsystem.service;
import com.itsupport.ticketingsystem.entity.Ticket;
import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicketStatus(Long id, String status);
}
