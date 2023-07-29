package com.bugtracker.controller;

import com.bugtracker.dao.JdbcTicketsDao;
import com.bugtracker.model.Tickets;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TicketsController {

    private final JdbcTicketsDao jdbcTicketsDao;

    public TicketsController(JdbcTicketsDao jdbcTicketsDao) {
        this.jdbcTicketsDao = jdbcTicketsDao;
    }

    @GetMapping("/tickets")
    public List<Tickets> findAll() {
        return jdbcTicketsDao.listAllTickets();
    }


    @GetMapping("/tickets/{ticketId}")
    public Tickets getByTicketId(@PathVariable int ticketId) {
        return jdbcTicketsDao.findByTicketId(ticketId);
    }

}
