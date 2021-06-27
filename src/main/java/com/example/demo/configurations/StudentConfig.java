/*
 * Copyright (c) 2021. Haroldo Ramirez da Nobrega
 */

package com.example.demo.configurations;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student miriam = new Student(
                    "Miriam",
                    "miriam.teste@gmail.com",
                    LocalDate.of(2000, DECEMBER, 2)
            );
            Student jose = new Student(
                    "Jose",
                    "jose.teste@gmail.com",
                    LocalDate.of(2017, JANUARY, 1)
            );
            Student paulo = new Student(
                    "Paulo",
                    "paulo.teste@gmail.com",
                    LocalDate.of(2019, NOVEMBER, 23)
            );
            Student alex = new Student(
                    "Alex",
                    "alex.teste@msn.com",
                    LocalDate.of(2001, MARCH, 14)
            );
            Student haroldo = new Student(
                    "Haroldo",
                    "haroldo.teste@msn.com",
                    LocalDate.of(1986, DECEMBER, 2)
            );
            Student bruna = new Student(
                    "Bruna",
                    "natasharial@gmail.com",
                    LocalDate.of(1989, JUNE, 16)
            );
            repository.saveAll(
                    List.of(miriam, jose, paulo, alex, haroldo, bruna)
            );
        };
    }
}
