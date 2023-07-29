package com.bugtracker.dao;

import com.bugtracker.model.Tickets;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcTicketsDao implements TicketsDao {


    @Override
    public List<Tickets> listAllTickets() {
        return null;
    }

    @Override
    public Tickets findByTicketId(int ticketId) {
        return null;
    }

    @Override
    public Tickets findByBugListId(int bugListId) {
        return null;
    }

    @Override
    public Tickets findByUserId(int userId) {
        return null;
    }

    @Override
    public Tickets findByPriority(String priority) {
        return null;
    }

    @Override
    public Tickets findByStatus(String status) {
        return null;
    }

    @Override
    public Tickets findByCategory(String category) {
        return null;
    }

    @Override
    public Tickets createTicket(Tickets ticket) {
        return null;
    }

    @Override
    public Tickets updateTickets(Tickets ticket) {
        return null;
    }

    @Override
    public void deleteTicket(int ticketId) {

    }


    private Tickets mapRowToTickets(SqlRowSet results) {
        Tickets ticket = new Tickets();
        ticket.setTicketId(results.getInt("ticket_id"));
        ticket.setTitle(results.getString("title"));
        ticket.setDescription(results.getString("description"));
        ticket.setUserId(results.getInt("user_id"));
        ticket.setBugListId(results.getInt("bug_list_id"));
        ticket.setPriority(results.getString("priority"));
        ticket.setStatus(results.getString("status"));
        ticket.setTicketCategory(results.getString("ticket_category"));
        return ticket;
    }

}
