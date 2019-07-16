package com.example.models;

import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "usr")
public class User {

    public User() {
    }

    public User(String name, int age, String email, String passport) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.passport = passport;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    private String email;

    private String passport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }


    public static class Builder {
        private User user = new User();

        public Builder withId(Long id) {
            user.id = id;
            return this;
        }

        public Builder withName(String name) {
            user.name = name;
            return this;
        }

        public Builder withAge(int age) {
            user.age = age;
            return this;
        }

        public Builder withEmail(String email) {
            user.email = email;
            return this;
        }

        public Builder withPassport(String passport) {
            user.passport = passport;
            return this;
        }

        public User build() {
            return user;
        }

    }
}



