package com.vnpay.practice1.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vnpay.practice1.entities.StudentEntity;
import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentEntity> getAllStudent() {

        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity getStudentByID(@PathVariable String id) {

        return studentService.getStudentById(id);
    }

    @GetMapping("/proc/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getStudentByIDProc(@PathVariable String id) {

        return studentService.getStudentByIDProc(id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity deleteStudentByID(@PathVariable String id) {

        return studentService.delStudent(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity) {

        return studentService.createStudent(studentEntity);
    }

    @PostMapping("/proc")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity createStudentProc(@RequestBody StudentEntity studentEntity) {

        return studentService.createStudentProc(studentEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity, @PathVariable String id) {

        return studentService.updateStudent(studentEntity, id);
    }

    @PutMapping("/proc/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity updateStudentProc(@RequestBody StudentEntity studentEntity, @PathVariable String id) {

        return studentService.updateStudentProc(studentEntity, id);
    }

    @DeleteMapping("/proc/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentEntity deleteStudentByIDProc(@PathVariable String id) {

        return studentService.delStudent(id);
    }
}
