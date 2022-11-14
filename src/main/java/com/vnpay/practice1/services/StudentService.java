package com.vnpay.practice1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;

@Service
public interface StudentService {
    public List<StudentEntity> getAllStudent();
}
