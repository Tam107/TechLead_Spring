package com.techlead;

import com.techlead.dto.request.query1.Query15;
import com.techlead.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechleadApplication {

    @Value("${app.jwt.secret}")
    private String jwtSecret;
    private final UserRepository userRepository;

    public TechleadApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TechleadApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            // This is where you can add any startup logic if needed
            System.out.println("Techlead Application has started successfully!");
            System.out.println("Username "+ userRepository.findByEmail("admin@gmail.com"));
            Query15 query15 = testQuery15();
            System.out.println("Query15 Test: " + query15.toString());
            System.out.println("First Name: " + query15.getFirstName());
            System.out.println("Jwt secret: " + jwtSecret);
        };
    }

    public static Query15 testQuery15() {
        Query15 query15 = new Query15();
        query15.setFirstName("John");
        query15.setLastName("Doe");
        query15.setAddress("123 Main St");
        query15.setCity("Springfield");
        query15.setCountry("USA");
        return query15;
    }

}
