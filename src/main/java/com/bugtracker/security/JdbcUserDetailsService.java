package com.bugtracker.security;

import com.bugtracker.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT email, user_password, name FROM users " +
                    "JOIN roles ON users.role_id = roles.role_id " +
                    "WHERE email = ?";

        List<Users> users = jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) -> {
            String email = rs.getString("email");
            String password = rs.getString("user_password");
            String role = rs.getString("name");
            return new Users(email, password, role);

        });

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        Users user = users.get(0);
        UserDetails userDetails = new User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
        return userDetails;
    }
}
