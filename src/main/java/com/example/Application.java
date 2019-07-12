package com.example;

import com.example.models.User;
import com.example.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) {

        userRepo.save(new User("Max", 24, "max@gmail.com", "PS299081"));
        userRepo.save(new User("John", 26, "john@gmail.com", "PS299321"));
        userRepo.save(new User("William", 21, "Michael89@gmail.com", "PS23232"));
        userRepo.save(new User("Michael", 17, "john@gmail.com", "PS299321"));
        userRepo.save(new User("Alexander", 47, "Alexander_q@gmail.com", "PS23242"));
        userRepo.save(new User("Sophia", 29, "Sophia90@gmail.com", "PS321242"));
        userRepo.save(new User("Emma", 28, "Emma91@gmail.com", "PS350142"));
        userRepo.save(new User("Isabella", 65, "Sophia92@gmail.com", "PS329234"));
        userRepo.save(new User("Emily", 38, "Emily80@gmail.com", "PS321242"));
        userRepo.save(new User("Natalie", 62, "Natalie@gmail.com", "PS329909"));

    }

}
