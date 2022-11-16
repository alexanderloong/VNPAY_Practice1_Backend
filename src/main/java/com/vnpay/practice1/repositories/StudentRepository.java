package com.vnpay.practice1.repositories;

import java.util.Date;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vnpay.practice1.entities.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Procedure(value = "PKG_STUDENT.INSERT_DATA")
    public void createStudentProc(
            @Param("I_ID") String id,
            @Param("I_LASTNAME") String lastName,
            @Param("I_FIRSTNAME") String firstName,
            @Param("I_GENDER") String gender,
            @Param("I_BIRTHDAY") Date birthday,
            @Param("I_ADDRESS") String address,
            @Param("I_PHONENUMBER") String phoneNumber);

    @Procedure(name = "StudentEntity.DataByID")
    public Map<String, Object> getLastNameID(@Param("IO_ID") String id);

    @Procedure(value = "PKG_STUDENT.UPDATE_DATA")
    public void updateStudentProc(
            @Param("I_ID") String id,
            @Param("I_LASTNAME") String lastName,
            @Param("I_FIRSTNAME") String firstName,
            @Param("I_GENDER") String gender,
            @Param("I_BIRTHDAY") Date birthday,
            @Param("I_ADDRESS") String address,
            @Param("I_PHONENUMBER") String phoneNumber);

    @Procedure(value = "PKG_STUDENT.DELETE_DATA")
    public void deleteStudentProc(@Param("I_ID") String id);
}
