package com.example.api.utils;

import com.example.api.models.user.UserResponse;

import java.util.function.Predicate;

public final class UserResponseCondition {

    private UserResponseCondition() {
        throw new IllegalStateException("Illegal access to constructor");
    }

    public static Predicate<UserResponse> verifyName(String name) {
        return user -> user.getName().toLowerCase().contains(name);
    }

    public static Predicate<UserResponse> verifyPassport(String password) {
        return user -> user.getPassport().equals(password);
    }

    public static Predicate<UserResponse> verifyEmail(String email) {
        return user -> user.getEmail().equalsIgnoreCase(email);
    }

    public static Predicate<UserResponse> verifyMinAge(int minAge) {
        return user -> user.getAge() >= minAge;
    }

    public static Predicate<UserResponse> verifyMaxAge(int maxAge) {
        return user -> user.getAge() <= maxAge;
    }

}
