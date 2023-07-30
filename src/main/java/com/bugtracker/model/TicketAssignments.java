package com.bugtracker.model;

import java.util.Objects;

public class TicketAssignments {

    private int ticketAssignmentId;
    private int ticketId;
    private int userId;


    public TicketAssignments(int ticketAssignmentId, int ticketId, int userId) {
        this.ticketAssignmentId = ticketAssignmentId;
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public TicketAssignments() {

    }

    public int getTicketAssignmentId() {
        return ticketAssignmentId;
    }

    public void setTicketAssignmentId(int ticketAssignmentId) {
        this.ticketAssignmentId = ticketAssignmentId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "TicketAssignments{" +
                "ticketAssignmentId=" + ticketAssignmentId +
                ", ticketId=" + ticketId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketAssignments that = (TicketAssignments) o;
        return Objects.equals(ticketAssignmentId, that.ticketAssignmentId) && Objects.equals(ticketId, that.ticketId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketAssignmentId, ticketId, userId);
    }
}
