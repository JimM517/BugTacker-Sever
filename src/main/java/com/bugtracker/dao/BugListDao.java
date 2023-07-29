package com.bugtracker.dao;

import com.bugtracker.model.BugList;
import com.bugtracker.model.Users;

import java.util.List;

public interface BugListDao {


    List<BugList> listAllCurrentProject();

    List<Users> getUsersOnCurrentBuglist(int userId);

    BugList getByBugListId(int bugListId);

    BugList createBugList(BugList newBugList);

    BugList update(BugList bugList);

    BugList findByUser(Users user);

    void deleteBugList(int bugListId);



}
