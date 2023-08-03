package com.bugtracker.controller;

import com.bugtracker.dao.JdbcUsersDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    private final JdbcUsersDao jdbcUsersDao;

    public AuthController(JdbcUsersDao jdbcUsersDao) {
        this.jdbcUsersDao = jdbcUsersDao;
    }

    @GetMapping("/login")
    public String home() {
        return "hello, world!";
    }


    @GetMapping("/admin")
    public String admin() {
        return "hello, admin!";
    }


//    @GetMapping("/login")
//    public List<Users> getAllUsers() {
//        return jdbcUsersDao.findAll();
//    }






}
