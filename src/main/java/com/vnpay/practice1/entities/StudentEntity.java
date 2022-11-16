package com.vnpay.practice1.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name = "StudentEntity.DataByID", procedureName = "PKG_STUDENT.GET_DATA_BY_ID", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "IO_ID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_FIRSTNAME", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_GENDER", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_BIRTHDAY", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_ADDRESS", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_PHONENUMBER", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "O_LASTNAME", type = String.class)
}))

public class StudentEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String lastName;
    private String firstName;
    private String gender;
    private Date birthday;
    private String address;
    private String phoneNumber;
}
