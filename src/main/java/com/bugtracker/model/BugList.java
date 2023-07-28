package com.bugtracker.model;

import java.time.LocalDate;
import java.util.List;

public class BugList {

    private Long bugListId;
    private String name;
    private String description;
    private List<Ticket> tickets;
    private LocalDate createdAt;


    public BugList(Long bugListId, String name, String description, List<Ticket> tickets, LocalDate createdAt) {
        this.bugListId = bugListId;
        this.name = name;
        this.description = description;
        this.tickets = tickets;
        //possibly need to update to LocalDate.now()?
        this.createdAt = createdAt;
    }

    public BugList() {

    }

    public Long getBugListId() {
        return bugListId;
    }

    public void setBugListId(Long bugListId) {
        this.bugListId = bugListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ticket[] getTickets() {
        Ticket[] results = new Ticket[tickets.size()];
        return tickets.toArray(results);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }




}
