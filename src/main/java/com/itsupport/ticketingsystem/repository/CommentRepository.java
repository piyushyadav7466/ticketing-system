package com.itsupport.ticketingsystem.repository;

import com.itsupport.ticketingsystem.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Load all comments for a specific ticket
    List<Comment> findByTicketId(Long ticketId);
}