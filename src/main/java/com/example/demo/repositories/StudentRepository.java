/*
 * Copyright (c) 2021. Haroldo Ramirez da Nobrega
 */

package com.example.demo.repositories;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // SELECT * FROM student where email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findByStudentByEmail(String email);
}
