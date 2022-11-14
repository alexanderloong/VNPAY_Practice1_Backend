package com.vnpay.practice1.services.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;
import com.vnpay.practice1.repositories.StudentRepository;
import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudent() {

        return studentRepository.findAll();
    }

}
