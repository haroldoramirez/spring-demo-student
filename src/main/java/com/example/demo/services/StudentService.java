/*
 * Copyright (c) 2021. Haroldo Ramirez da Nobrega
 */

package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findByStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {

        boolean exist = studentRepository.existsById(studentId);

        if (!exist) {
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {


        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists"));

        //Se o nome for diferente de nulo e que o nome seja diferente do objeto encontrado no findById
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        //Regra de negocio para atualizar o email pois precisamos garantir que nao tenha duplicidade de dados
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository.findByStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }

            student.setEmail(email);
        }
    }
}
