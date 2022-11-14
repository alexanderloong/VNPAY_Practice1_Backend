package com.vnpay.practice1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }
}
