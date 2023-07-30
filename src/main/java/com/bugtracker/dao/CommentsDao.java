package com.bugtracker.dao;

import com.bugtracker.model.Comments;

import java.util.List;

public interface CommentsDao {

    List<Comments> listAllComments();

    Comments findByCommentId(int commentId);

    Comments findByTicketId(int ticketId);

    Comments findByUserId(int userId);

    Comments createComment(Comments comment);

    Comments updateComment(Comments modifiedComment);

    void deleteComment(int commentId);

}
