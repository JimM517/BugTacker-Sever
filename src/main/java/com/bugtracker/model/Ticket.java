package com.bugtracker.model;

import java.time.LocalDateTime;

public class Ticket {

    private Long ticketId;
    private BugList bugList;
    private String title;
    private String description;
    private String status;
    private User assignedTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Ticket(Long ticketId, BugList bugList, String title, String description, String status, User assignedTo, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.ticketId = ticketId;
        this.bugList = bugList;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Ticket() {

    }

    public Long getId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public BugList getBugList() {
        return bugList;
    }

    public void setBugList(BugList bugList) {
        this.bugList = bugList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

}
