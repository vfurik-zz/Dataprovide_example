package com.example.data;


import io.github.sskorol.data.FieldName;
import io.github.sskorol.data.Source;
import org.apache.tika.config.Field;

@Source(path = "data.csv")
public class UserData {

    public UserData() {
    }

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
