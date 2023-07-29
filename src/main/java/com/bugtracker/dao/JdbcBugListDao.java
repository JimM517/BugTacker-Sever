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

    //TODO JULY 29
    // may need to come back to this
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
        String sql = "INSERT INTO bug_lists (title, description, user_id) VALUES (?, ?, ?) RETURNING bug_list_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newBugList.getTitle(), newBugList.getDescription(), newBugList.getUserId());
        return getByBugListId(newId);
    }

    @Override
    public BugList update(BugList modifiedBugList) {
        String sql = "UPDATE bug_lists SET bug_list_id = ?, title = ?, description = ?, user_id = ? WHERE bug_list_id = ?";
        jdbcTemplate.update(sql, modifiedBugList.getBugListId(), modifiedBugList.getTitle(), modifiedBugList.getDescription(), modifiedBugList.getUserId(), modifiedBugList.getBugListId() );
        return getByBugListId(modifiedBugList.getBugListId());
    }

    //TODO JULY 29
    // MAY BE BETTER TO HANDLE IN SERVICE CLASS
    @Override
    public BugList findByUserId(int userId) {
        return null;
    }

    //Simple function to add user by id, will handle the rest in service layer??
    public void addUserToBugList(int bugListId, int addedUserId) {
        String sql = "UPDATE bug_list SET user_id = ? WHERE bug_list_id = ?";
        jdbcTemplate.update(sql, addedUserId, bugListId);
    }

    //TODO JULY 29
    // MAY NEED TO UPDATE THIS LATER, CHECK RELATIONSHIPS, JUST TRYING TO GET OVERALL STRUCTURE IN MOTION
    @Override
    public void deleteBugList(int bugListId) {
        String sql = "DELETE FROM bug_lists WHERE bug_list_id = ?";
        jdbcTemplate.update(sql, bugListId);


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
