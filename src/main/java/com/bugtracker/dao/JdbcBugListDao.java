package com.bugtracker.dao;

import com.bugtracker.model.BugList;
import com.bugtracker.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBugListDao implements BugListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBugListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<BugList> listAllCurrentProject() {
        List<BugList> results = new ArrayList<>();
        String sql = "SELECT * FROM bug_lists";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        while(row.next()) {
            BugList bugList = mapRowToBugList(row);
            results.add(bugList);
        }
        return results;
    }

    //TODO may need to come back to this
    @Override
    public List<Users> getUsersOnCurrentBuglist(int userId) {
        List<Users> results = new ArrayList<>();

        String sql = "SELECT first_name, last_name FROM users " +
                    "JOIN bug_lists ON bug_lists.user_id = users.user_id " +
                    "WHERE bug_lists.user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
        while(row.next()) {
            Users user = new Users();
            user.setFirstName(row.getString("first_name"));
            user.setLastName(row.getString("last_name"));
            results.add(user);
        }
        return results;
    }

    @Override
    public BugList getByBugListId(int bugListId) {
        BugList bugList = null;
        String sql = "SELECT * FROM bug_lists WHERE bug_list_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, bugListId);
        if (row.next()) {
            bugList = mapRowToBugList(row);
        }
        return bugList;
    }

    @Override
    public BugList createBugList(BugList newBugList) {
        return null;
    }

    @Override
    public BugList update(BugList bugList) {
        return null;
    }

    @Override
    public BugList findByUser(Users user) {
        return null;
    }

    @Override
    public void deleteBugList(int bugListId) {

    }


    private BugList mapRowToBugList(SqlRowSet results) {
        BugList bugList = new BugList();
        bugList.setBugListId(results.getInt("bug_list_id"));
        bugList.setTitle(results.getString("title"));
        bugList.setDescription(results.getString("description"));
        bugList.setUserId(results.getInt("user_id"));
        return bugList;
    }

}
