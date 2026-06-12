package com.itsupport.ticketingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Piyush Kumar Yadav
 */
@Entity
@Table(name = "users")
@Data // Lombok: auto-generates getters, setters, toString, etc.
@NoArgsConstructor // Lombok: empty constructor required by JPA
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @JsonIgnore
    @Column(nullable = false)
    private String role; // e.g., EMPLOYEE, SUPPORT_ENGINEER, ADMIN
}