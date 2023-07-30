package com.bugtracker.service;

import com.bugtracker.dao.*;
import com.bugtracker.model.BugList;
import com.bugtracker.model.Users;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.List;

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


    //Show all buglists
    public List<BugList> getBugLists() {
        return bugListDao.listAllCurrentProject();
    }


    //show the bug lists by user;
    public BugList showCurrentListByListIdAndUserId(int bugListId, int userId) {
        return bugListDao.getByListAndUserId(bugListId, userId);
    }












    //helper methods for service
    private Users getCurrentUser(Principal principal) {
        return usersDao.findByFirstName(principal.getName());
    }

    private int getUserId(Principal principal) {
        return usersDao.findIdFirstName(principal.getName());
    }

}
