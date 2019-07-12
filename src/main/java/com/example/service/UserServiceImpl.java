package com.example.service;

import com.example.filter.UserFilter;
import com.example.models.User;
import com.example.repos.UserRepo;
import com.example.utils.UserFilterFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll(UserFilter userFilter) {
        return userRepo.findAll().stream()
                .filter(UserFilterFunction.valueContainsIgnoreCase(userFilter.getName(), User::getName))
                .filter(UserFilterFunction.isEquals(userFilter.getPassport(), User::getPassport))
                .filter(UserFilterFunction.valueEqualsIgnoreCase(userFilter.getEmail(), User::getEmail))
                .filter(UserFilterFunction.ageGreaterThan(userFilter.getMinAge()))
                .filter(UserFilterFunction.ageLessThan(userFilter.getMaxAge()))
                .collect(Collectors.toList());
    }

}
