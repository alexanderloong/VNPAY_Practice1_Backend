package com.vnpay.practice1.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;
import com.vnpay.practice1.exceptions.NotFoundException;
import com.vnpay.practice1.repositories.StudentRepository;
import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudent() {
        List<StudentEntity> listStudent = studentRepository.findAll();

        if (listStudent.isEmpty() == true)
            throw new NotFoundException("Không có dữ liệu!");

        return listStudent;
    }

    @Override
    public StudentEntity getStudentById(long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);

        if (student.isEmpty() == true)
            throw new NotFoundException("Không có dữ liệu với ID là " + id);

        return student.get();
    }

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {

        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity delStudent(long id) {
        StudentEntity student = getStudentById(id);

        studentRepository.deleteById(id);

        return student;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, long id) {
        getStudentById(id);

        studentEntity.setId(id);

        return studentRepository.save(studentEntity);
    }
}
