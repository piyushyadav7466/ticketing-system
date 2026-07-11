# Ticketing System

A full-stack support ticket management application built with Spring Boot, Spring Security, and MySQL. This system enables efficient tracking, management, and resolution of support tickets with user authentication, role-based access control, and real-time status updates.

## Features

- **User Authentication & Authorization**
  - Secure user registration and login with JWT tokens
  - Role-based access control (Admin, Support Staff, Users)
  - Spring Security integration with password encryption

- **Ticket Management**
  - Create, view, update, and delete support tickets
  - Track ticket status (Open, In Progress, Resolved, Closed)
  - Assign tickets to support staff members
  - Add priority levels to tickets

- **Comments & Collaboration**
  - Add comments to tickets for team communication
  - Track comment history and updates
  - Collaborative ticket resolution workflow

- **Dashboard & Analytics**
  - Admin dashboard for ticket overview
  - Real-time status tracking
  - User dashboard to view their tickets

## Tech Stack

### Backend
- **Runtime:** Java 25
- **Framework:** Spring Boot 3.5.14
- **Security:** Spring Security with JWT (JJWT 0.11.5)
- **Database Access:** Spring Data JPA
- **Build Tool:** Maven

### Database
- **MySQL:** Relational database for persistent storage

### Key Dependencies
- `spring-boot-starter-web` - REST API development
- `spring-boot-starter-data-jpa` - ORM and database interactions
- `spring-boot-starter-security` - Authentication and authorization
- `jjwt` - JWT token generation and validation
- `mysql-connector-j` - MySQL database driver
- `lombok` - Reduce boilerplate code with annotations

## Project Structure
