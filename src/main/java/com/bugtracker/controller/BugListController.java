package com.bugtracker.controller;

import com.bugtracker.dao.JdbcBugListDao;
import com.bugtracker.model.BugList;
import com.bugtracker.model.Users;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BugListController {

    private final JdbcBugListDao jdbcBugListDao;

    public BugListController(JdbcBugListDao jdbcBugListDao) {
        this.jdbcBugListDao = jdbcBugListDao;
    }


    //TODO JULY 29 JUST CHECKING IF THESE ENDPOINTS WORK, WILL REFACTOR ONCE BUSINESS LOGIC IS IN PLACE
    @GetMapping("/bugs")
    public List<BugList> listAllBugs() {
        return jdbcBugListDao.listAllCurrentProject();
    }

    @GetMapping("/bugs/{userId}")
    public List<Users> findUsersOnCurrentIssue(@PathVariable int userId) {
        return jdbcBugListDao.getUsersOnCurrentBuglist(userId);
    }


}
