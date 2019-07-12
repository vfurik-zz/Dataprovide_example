package com.example.utils;

import com.example.models.User;

import java.util.function.Predicate;

public class UserFunction {

    public final static Predicate<User> nameIsEmpty = u -> u.getName().isEmpty();

    public final static Predicate<User> isNoAdult = u -> u.getAge() < 18;

}
