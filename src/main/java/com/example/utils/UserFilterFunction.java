package com.example.utils;

import com.example.models.User;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public final class UserFilterFunction {

    private UserFilterFunction() {
        throw new IllegalStateException("Illegal access to constructor");
    }

    public static <T> Predicate<T> isEquals(String value, Function<T, String> function) {
        return entity -> Objects.isNull(value) || function.apply(entity).equals(value);
    }

    public static <T> Predicate<T> valueContainsIgnoreCase(String value, Function<T, String> function) {
        return entity -> Objects.isNull(value) || function.apply(entity).toLowerCase().contains(value.toLowerCase());
    }

    public static <T> Predicate<T> valueEqualsIgnoreCase(String value, Function<T, String> function) {
        return entity -> Objects.isNull(value) || function.apply(entity).toLowerCase().equals(value.toLowerCase());
    }

    public static Predicate<User> ageGreaterThan(Integer value) {
        return entity -> Objects.isNull(value) || entity.getAge() >= value;
    }

    public static Predicate<User> ageLessThan(Integer value) {
        return entity -> Objects.isNull(value) || entity.getAge() <= value;
    }

}
