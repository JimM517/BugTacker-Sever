package com.bugtracker.model;

import java.util.Objects;

public class Comments {

    private Long commentId;
    private Long ticketId;
    private Long userId;
    private String message;

    public Comments(Long commentId, Long ticketId, Long userId, String message) {
        this.commentId = commentId;
        this.ticketId = ticketId;
        this.userId = userId;
        this.message = message;
    }

    public Comments() {

    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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
