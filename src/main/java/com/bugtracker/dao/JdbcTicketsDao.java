package com.bugtracker.dao;

import com.bugtracker.model.Tickets;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTicketsDao implements TicketsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTicketsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tickets> listAllTickets() {
        List<Tickets> results = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        while(row.next()) {
            Tickets ticket = mapRowToTickets(row);
            results.add(ticket);
        }
        return results;
    }

    @Override
    public Tickets findByTicketId(int ticketId) {
        Tickets ticket = null;
        String sql = "SELECT * FROM tickets WHERE ticket_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, ticketId);
        if (row.next()) {
            ticket = mapRowToTickets(row);
        }
        return ticket;
    }

    @Override
    public Tickets findByBugListId(int bugListId) {
        Tickets ticket = null;
        String sql = "SELECT * FROM tickets WHERE bug_list_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, bugListId);
        if (row.next()) {
            ticket = mapRowToTickets(row);
        }
        return ticket;
    }

    @Override
    public List<Tickets> findByUserId(int userId) {
        List<Tickets> results = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
        while(row.next()) {
            Tickets ticket = mapRowToTickets(row);
            results.add(ticket);
        }
        return results;
    }

    @Override
    public List<Tickets> findByPriority(String priority) {
        List<Tickets> results = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE priority = ? ORDER BY ticket_id";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, priority);
        while(row.next()) {
            Tickets ticket = mapRowToTickets(row);
            results.add(ticket);
        }
        return results;
    }

    @Override
    public List<Tickets> findByStatus(String status) {
        List<Tickets> results = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE status = ? ORDER BY ticket_id";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, status);
        while(row.next()) {
            Tickets ticket = mapRowToTickets(row);
            results.add(ticket);
        }
        return results;
    }

    @Override
    public List<Tickets> findByCategory(String category) {
        List<Tickets> results = new ArrayList<>();
        String sql = "SELECT * FROM tickets WHERE ticket_category = ? ORDER BY ticket_id";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, category);
        while(row.next()) {
            Tickets ticket = mapRowToTickets(row);
            results.add(ticket);
        }
        return results;
    }

    @Override
    public Tickets createTicket(Tickets newTicket) {
        String sql = "INSERT INTO tickets (title, description, user_id, bug_list_id, priority, status, ticket_category) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING ticket_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newTicket.getTitle(), newTicket.getDescription(), newTicket.getUserId(), newTicket.getBugListId(), newTicket.getPriority(), newTicket.getStatus(), newTicket.getTicketCategory());
        return findByTicketId(newId);
    }

    @Override
    public Tickets updateTickets(Tickets modifiedTicket) {
        String sql = "UPDATE tickets SET title = ?, description = ?, user_id = ?, bug_list_id = ?, priority = ?, status = ?, ticket_category = ? WHERE ticket_id = ?";
        jdbcTemplate.update(sql, modifiedTicket.getTitle(), modifiedTicket.getDescription(), modifiedTicket.getUserId(), modifiedTicket.getBugListId(), modifiedTicket.getPriority(), modifiedTicket.getStatus(), modifiedTicket.getTicketCategory(), modifiedTicket.getTicketId());
        return findByTicketId(modifiedTicket.getTicketId());
    }

    //TODO JULY 29 PROBABLY NEED TO CHANGE THIS
    @Override
    public void deleteTicket(int ticketId) {
        String sql = "DELETE FROM tickets WHERE ticket_id = ?";
        jdbcTemplate.update(sql, ticketId);

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
