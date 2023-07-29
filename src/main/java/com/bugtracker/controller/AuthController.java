package com.bugtracker.controller;

import com.bugtracker.dao.JdbcUsersDao;
import com.bugtracker.model.Users;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AuthController {

    private final JdbcUsersDao jdbcUsersDao;

    public AuthController(JdbcUsersDao jdbcUsersDao) {
        this.jdbcUsersDao = jdbcUsersDao;
    }


    @GetMapping("/login")
    public List<Users> getAllUsers() {
        return jdbcUsersDao.findAll();
    }






}
