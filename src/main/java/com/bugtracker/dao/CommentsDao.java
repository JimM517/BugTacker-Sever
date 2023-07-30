package com.bugtracker.dao;

import com.bugtracker.model.Comments;

import java.util.List;

public interface CommentsDao {

    List<Comments> listAllComments();

    Comments findByCommentId(int commentId);

    List<Comments> findByTicketId(int ticketId);

    List<Comments> findByUserId(int userId);

    Comments createComment(Comments newComment);

    Comments updateComment(Comments modifiedComment);

    void deleteComment(int commentId);

}
