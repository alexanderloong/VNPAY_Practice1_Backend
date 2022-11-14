package com.vnpay.practice1.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnpay.practice1.entities.StudentEntity;
import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudent() {
        return new ResponseEntity<List<StudentEntity>>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
        return new ResponseEntity<StudentEntity>(studentService.createStudent(studentEntity), HttpStatus.CREATED);
    }
}
