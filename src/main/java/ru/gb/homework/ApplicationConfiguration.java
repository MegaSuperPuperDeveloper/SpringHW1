package ru.gb.homework;

import org.springframework.context.annotation.Bean;

// java-based configuration
//@Configuration
public class ApplicationConfiguration {

    @Bean
    StudentRepository myUserRepository() {
        return new StudentRepository();
    }

}
