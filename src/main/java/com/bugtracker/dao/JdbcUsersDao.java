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
        return null;
    }

    @Override
    public Users getUser(int userId) {
        return null;
    }

    @Override
    public int findIdFirstName(String firstName) {
        return 0;
    }

    @Override
    public Users create(Users newUser) {
        return null;
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
