package com.bugtracker.dao;

import com.bugtracker.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUsersDao implements UsersDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUsersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Users> findAll() {
        List<Users> results = new ArrayList<>();
        String sql = "SELECT * FROM users";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);
        while(row.next()) {
            Users user = mapRowToUser(row);
            results.add(user);
        }
        return results;
    }

    @Override
    public Users getRole(int roleId) {
        Users user = null;
        String sql = "SELECT * FROM users " +
                    "JOIN roles ON roles.role_id = users.role_id " +
                    "WHERE users.role_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, roleId);
        if (row.next()) {
            user = mapRowToUser(row);
        }
        return user;
    }

    @Override
    public Users getUser(int userId) {
        Users user = new Users();
        String sql = "SELECT * FROM users WHERE user_id = ?";
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);
        if (row.next()) {
            user = mapRowToUser(row);
        }
        return user;
    }

    @Override
    public Users findByFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("First name cannot be blank!");
        Users foundUser = null;
        try {
            for (Users user : this.findAll()) {
                if (user.getFirstName().equalsIgnoreCase(firstName)) {
                    foundUser = user;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return foundUser;
    }

    //TODO maybe want to update this to accept wildcard params?
    @Override
    public int findIdFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("First name cannot be blank!");
        int userId = 0;
        try {
            String sql = "SELECT user_id FROM users WHERE first_name = ?";
            userId = jdbcTemplate.queryForObject(sql, int.class, firstName);
        } catch (Exception e) {
            e.getMessage();
        }
        return userId;
    }

    @Override
    public Users create(Users newUser) {
        String sql = "INSERT INTO users (first_name, last_name, role_id, email, user_password) VALUES (?, ?, ?, ?, ?) RETURNING user_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newUser.getFirstName(), newUser.getLastName(), newUser.getRoleId(), newUser.getEmail(), newUser.getPassword());
//        newUser.setUserId(newId);
//        return newUser;
        return getUser(newId);
    }


    private Users mapRowToUser(SqlRowSet results) {
        Users user = new Users();
        user.setUserId(results.getInt("user_id"));
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setRoleId(results.getInt("role_id"));
        user.setEmail(results.getString("email"));
        user.setPassword(results.getString("user_password"));
        return user;
    }



}
