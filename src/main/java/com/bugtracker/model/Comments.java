package com.bugtracker.model;

import java.util.Objects;

public class Comments {

    private int commentId;
    private int ticketId;
    private int userId;
    private String message;

    public Comments(int commentId, int ticketId, int userId, String message) {
        this.commentId = commentId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.message = message;
    }

    public Comments() {

    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", ticketId=" + ticketId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(commentId, comments.commentId) && Objects.equals(ticketId, comments.ticketId) && Objects.equals(userId, comments.userId) && Objects.equals(message, comments.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, ticketId, userId, message);
    }
}
