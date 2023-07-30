package com.bugtracker.dao;

import com.bugtracker.model.TicketAssignments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTicketAssignmentDao implements TicketAssignmentsDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcTicketAssignmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<TicketAssignments> listAllCurrentAssignedTickets() {
        List<TicketAssignments> results = new ArrayList<>();
        String sql = "SELECT * FROM ticket_assignments";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        while(row.next()) {
            TicketAssignments ticketAssignment = mapRowToAssignments(row);
            results.add(ticketAssignment);
        }
        return results;
    }

    @Override
    public TicketAssignments findByTicketId(int tickedId) {
        TicketAssignments ticketAssignment = null;
        String sql = "SELECT * FROM ticket_assignments WHERE ticket_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, tickedId);
        while(row.next()) {
            ticketAssignment = mapRowToAssignments(row);
        }
        return ticketAssignment;
    }

    //assuming users can have more than one assignment
    @Override
    public List<TicketAssignments> findByUserId(int userId) {
        List<TicketAssignments> results = new ArrayList<>();
        String sql = "SELECT * FROM ticket_assignments WHERE user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
        while(row.next()) {
            TicketAssignments ticketAssignments = mapRowToAssignments(row);
            results.add(ticketAssignments);
        }
        return results;
    }

    @Override
    public TicketAssignments createAssignment(TicketAssignments newAssignment) {
        String sql = "UPDATE ticket_assignments (ticket_id, user_id) VALUES (?, ?) RETURNING ticket_assignment_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newAssignment.getTicketId(), newAssignment.getUserId());
        return findByTicketId(newId);
    }

    @Override
    public TicketAssignments updateAssignment(TicketAssignments modifiedAssignment) {
        String sql = "UPDATE ticket_assignments SET ticket_id = ?, user_id = ? WHERE ticket_assignment_id = ?";
        jdbcTemplate.update(sql, modifiedAssignment.getTicketId(), modifiedAssignment.getUserId(), modifiedAssignment.getTicketAssignmentId());
        return findByTicketId(modifiedAssignment.getTicketId());
    }


    private TicketAssignments mapRowToAssignments(SqlRowSet results) {
        TicketAssignments ticketAssignment = new TicketAssignments();
        ticketAssignment.setTicketAssignmentId(results.getInt("ticket_assignment_id"));
        ticketAssignment.setTicketId(results.getInt("ticket_id"));
        ticketAssignment.setUserId(results.getInt("user_id"));
        return ticketAssignment;
    }


}
