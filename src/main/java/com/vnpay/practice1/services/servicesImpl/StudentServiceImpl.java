package com.vnpay.practice1.services.servicesImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vnpay.practice1.entities.StudentEntity;
import com.vnpay.practice1.exceptions.NotFoundException;
import com.vnpay.practice1.repositories.StudentRepository;
import com.vnpay.practice1.services.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
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
    public StudentEntity getStudentById(String id) {
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
    public StudentEntity delStudent(String id) {
        StudentEntity student = getStudentById(id);

        studentRepository.deleteById(id);

        return student;
    }

    @Override
    public StudentEntity updateStudent(StudentEntity studentEntity, String id) {
        getStudentById(id);

        studentEntity.setId(id);

        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity createStudentProc(StudentEntity studentEntity) {
        UUID uuid = UUID.randomUUID();

        studentEntity.setId(uuid.toString());
        studentRepository.createStudentProc(
                studentEntity.getId(),
                studentEntity.getLastName(),
                studentEntity.getFirstName(),
                studentEntity.getGender(),
                studentEntity.getBirthday(),
                studentEntity.getAddress(),
                studentEntity.getPhoneNumber());

        return studentEntity;
    }

    @Override
    public Map<String, Object> getStudentByIDProc(String id) {
        if (studentRepository.findById(id).isEmpty() == true)
            throw new NotFoundException("Không có dữ liệu với ID là " + id);

        Map<String, Object> data = studentRepository.getLastNameID(id);

        return data;

    }

    @Override
    public StudentEntity updateStudentProc(StudentEntity studentEntity, String id) {
        if (studentRepository.findById(id).isEmpty() == true)
            throw new NotFoundException("Không có dữ liệu với ID là " + id);

        studentEntity.setId(id);

        studentRepository.updateStudentProc(
                studentEntity.getId(),
                studentEntity.getLastName(),
                studentEntity.getFirstName(),
                studentEntity.getGender(),
                studentEntity.getBirthday(),
                studentEntity.getAddress(),
                studentEntity.getPhoneNumber());

        return studentEntity;
    }

    @Override
    public StudentEntity deleteStudentProc(String id) {
        Optional<StudentEntity> student = studentRepository.findById(id);

        if (student.isEmpty() == true)
            throw new NotFoundException("Không có dữ liệu với ID là " + id);

        studentRepository.deleteStudentProc(id);

        return student.get();
    }
}
