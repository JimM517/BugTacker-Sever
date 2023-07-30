package com.bugtracker.dao;

import com.bugtracker.model.Comments;

import java.util.List;

public class JdbcCommentsDao implements CommentsDao {


    @Override
    public List<Comments> listAllComments() {
        return null;
    }

    @Override
    public Comments findByCommentId(int commentId) {
        return null;
    }

    @Override
    public Comments findByTicketId(int ticketId) {
        return null;
    }

    @Override
    public Comments findByUserId(int userId) {
        return null;
    }

    @Override
    public Comments createComment(Comments comment) {
        return null;
    }

    @Override
    public Comments updateComment(Comments modifiedComment) {
        return null;
    }

    @Override
    public void deleteComment(int commentId) {

    }
}
