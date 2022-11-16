package com.vnpay.practice1.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;

@Service
public interface StudentService {
    // Entity
    public List<StudentEntity> getAllStudent();

    public StudentEntity getStudentById(String id);

    public StudentEntity createStudent(StudentEntity studentEntity);

    public StudentEntity delStudent(String id);

    public StudentEntity updateStudent(StudentEntity studentEntity, String id);

    // Proc
    public Map<String, Object> getStudentByIDProc(String id);

    public StudentEntity createStudentProc(StudentEntity studentEntity);

    public StudentEntity updateStudentProc(StudentEntity studentEntity, String id);

    public StudentEntity deleteStudentProc(String id);

}
