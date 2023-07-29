package com.bugtracker.dao;

import com.bugtracker.model.Tickets;

import java.util.List;

public interface TicketsDao {

    List<Tickets> listAllTickets();

    Tickets findByTicketId(int ticketId);

    Tickets findByBugListId(int bugListId);

    List<Tickets> findByUserId(int userId);

   List<Tickets> findByPriority(String priority);

    List<Tickets> findByStatus(String status);

    List<Tickets>findByCategory(String category);

    Tickets createTicket(Tickets newTicket);

    Tickets updateTickets(Tickets modifiedTicket);

    void deleteTicket(int ticketId);


}
