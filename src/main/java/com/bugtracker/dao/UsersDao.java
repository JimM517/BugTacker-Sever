package com.bugtracker.dao;

import com.bugtracker.model.Users;

import java.util.List;

public interface UsersDao {

    List<Users> findAll();

    Users getRole(int roleId);

    Users getUser(int userId);

    //will probably change this once JWT/security is implemented
    Users findByFirstName(String firstName);

    int findIdFirstName(String firstName);

    Users create(Users newUser);







}
