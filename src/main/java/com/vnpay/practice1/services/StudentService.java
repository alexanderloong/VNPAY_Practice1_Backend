package com.vnpay.practice1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;

@Service
public interface StudentService {
    public List<StudentEntity> getAllStudent();

    public StudentEntity getStudentById(long id);

    public StudentEntity createStudent(StudentEntity studentEntity);

    public StudentEntity delStudent(long id);

    public StudentEntity updateStudent(StudentEntity studentEntity, long id);
}
