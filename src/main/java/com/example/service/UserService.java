package com.example.service;

import com.example.filter.UserFilter;
import com.example.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll(UserFilter userFilter);

}
