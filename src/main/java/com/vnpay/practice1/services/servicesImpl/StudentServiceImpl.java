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

    @Override
    public StudentEntity getStudentById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {

        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity delStudent(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
