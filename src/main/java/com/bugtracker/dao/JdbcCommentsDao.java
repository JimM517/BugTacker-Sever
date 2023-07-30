package com.bugtracker.dao;

import com.bugtracker.model.Comments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentsDao implements CommentsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Comments> listAllComments() {
        List<Comments> results = new ArrayList<>();
        String sql = "SELECT * FROM comments";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        while(row.next()) {
            Comments comment = mapRowToComments(row);
            results.add(comment);
        }
        return results;
    }

    @Override
    public Comments findByCommentId(int commentId) {
        Comments comment = null;
        String sql = "SELECT * FROM comments WHERE comment_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        if (row.next()) {
            comment = mapRowToComments(row);
        }
        return comment;
    }

    @Override
    public List<Comments> findByTicketId(int ticketId) {
        List<Comments> results = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE ticket_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, ticketId);
        while(row.next()) {
            Comments comment = mapRowToComments(row);
            results.add(comment);
        }
        return results;
    }

    @Override
    public List<Comments> findByUserId(int userId) {
        List<Comments> results = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
        while(row.next()) {
            Comments comment = mapRowToComments(row);
            results.add(comment);
        }
        return results;
    }

    @Override
    public Comments createComment(Comments newComment) {
        String sql = "INSERT INTO comments (ticket_id, user_id, message) VALUES (?, ?, ?) RETURNING comment_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newComment.getTicketId(), newComment.getUserId(), newComment.getMessage());
        return findByCommentId(newId);
    }

    @Override
    public Comments updateComment(Comments modifiedComment) {
        String sql = "UPDATE comments SET ticket_id = ?, user_id = ?, message = ? WHERE comment_id = ?";
        jdbcTemplate.update(sql, modifiedComment.getTicketId(), modifiedComment.getUserId(), modifiedComment.getMessage(), modifiedComment.getCommentId());
        return findByCommentId(modifiedComment.getCommentId());
    }

    //TODO JULY 29 PROBABLY NEED TO FIX THIS
    @Override
    public void deleteComment(int commentId) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(sql, commentId);
    }


    private Comments mapRowToComments(SqlRowSet results) {
        Comments comment = new Comments();
        comment.setCommentId(results.getInt("comment_id"));
        comment.setTicketId(results.getInt("ticket_id"));
        comment.setUserId(results.getInt("user_id"));
        comment.setMessage(results.getString("message"));
        return comment;
    }


}
