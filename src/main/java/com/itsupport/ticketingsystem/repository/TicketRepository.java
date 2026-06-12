package com.itsupport.ticketingsystem.repository;

import com.itsupport.ticketingsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Find all tickets requested by a specific user ID
    List<Ticket> findByRequesterId(Long requesterId);

    // Find all tickets assigned to a specific engineer ID
    List<Ticket> findByAssigneeId(Long assigneeId);
}
