package com.example.filter;

public class UserFilter {

    public UserFilter() {
    }

    public UserFilter(String name, String email, String passport, int minAge, int maxAge) {
        this.name = name;
        this.email = email;
        this.passport = passport;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    private String name;

    private String email;

    private String passport;

    private Integer minAge;

    private Integer maxAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "UserFilter{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                '}';
    }
}
