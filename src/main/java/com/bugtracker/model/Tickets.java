package com.bugtracker.model;

import java.util.Objects;

public class Tickets {

    private int ticketId;
    private String title;
    private String description;
    private int userId;
    private int bugListId;
    private String priority;
    private String status;
    private String ticketCategory;


    public Tickets(int ticketId, String title, String description, int userId, int bugListId, String priority, String status, String ticketCategory) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.bugListId = bugListId;
        this.priority = priority;
        this.status = status;
        this.ticketCategory = ticketCategory;
    }

    public Tickets() {

    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBugListId() {
        return bugListId;
    }

    public void setBugListId(int bugListId) {
        this.bugListId = bugListId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", bugListId=" + bugListId +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", ticketCategory='" + ticketCategory + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(ticketId, tickets.ticketId) && Objects.equals(title, tickets.title) && Objects.equals(description, tickets.description) && Objects.equals(userId, tickets.userId) && Objects.equals(bugListId, tickets.bugListId) && Objects.equals(priority, tickets.priority) && Objects.equals(status, tickets.status) && Objects.equals(ticketCategory, tickets.ticketCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, title, description, userId, bugListId, priority, status, ticketCategory);
    }
}
