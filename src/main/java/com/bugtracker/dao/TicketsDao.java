package com.bugtracker.dao;

import com.bugtracker.model.Tickets;

import java.util.List;

public interface TicketsDao {

    List<Tickets> listAllTickets();

    Tickets findByTicketId(int ticketId);

    Tickets findByBugListId(int bugListId);

    Tickets findByUserId(int userId);

    Tickets findByPriority(String priority);

    Tickets findByStatus(String status);

    Tickets findByCategory(String category);

    Tickets createTicket(Tickets ticket);

    Tickets updateTickets(Tickets ticket);

    void deleteTicket(int ticketId);


}
