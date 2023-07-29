package com.bugtracker.dao;

import com.bugtracker.model.Users;

import java.util.List;

public interface UsersDao {

    List<Users> findAll();

    Users getRole(int roleId);

    Users getUser(int userId);

    int findIdFirstName(String firstName);

    Users create(Users newUser);







}
