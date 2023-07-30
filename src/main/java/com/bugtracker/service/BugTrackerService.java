package com.bugtracker.service;

import com.bugtracker.dao.*;
import org.springframework.stereotype.Component;

@Component
public class BugTrackerService {


    private UsersDao usersDao;
    private BugListDao bugListDao;
    private TicketsDao ticketsDao;

    private CommentsDao commentsDao;

    private TicketAssignmentsDao ticketAssignmentsDao;

    public BugTrackerService(UsersDao usersDao, BugListDao bugListDao, TicketsDao ticketsDao, CommentsDao commentsDao, TicketAssignmentsDao ticketAssignmentsDao) {
        this.usersDao = usersDao;
        this.bugListDao = bugListDao;
        this.ticketsDao = ticketsDao;
        this.commentsDao = commentsDao;
        this.ticketAssignmentsDao = ticketAssignmentsDao;
    }


}
