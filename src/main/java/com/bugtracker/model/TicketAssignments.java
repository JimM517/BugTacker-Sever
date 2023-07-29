package com.bugtracker.model;

import java.util.Objects;

public class TicketAssignments {

    private Long ticketAssignmentId;
    private Long ticketId;
    private Long userId;


    public TicketAssignments(Long ticketAssignmentId, Long ticketId, Long userId) {
        this.ticketAssignmentId = ticketAssignmentId;
        this.ticketId = ticketId;
        this.userId = userId;
    }

    public TicketAssignments() {

    }

    public Long getTicketAssignmentId() {
        return ticketAssignmentId;
    }

    public void setTicketAssignmentId(Long ticketAssignmentId) {
        this.ticketAssignmentId = ticketAssignmentId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
