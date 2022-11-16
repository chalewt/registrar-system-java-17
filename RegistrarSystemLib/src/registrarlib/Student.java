/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ChalewT
 */
public class Student {

    String studentId;
    String name;
    String fatherName;
    String grandName;
    String sex;
    Date dateOfBirth;
    String phone;
    String email;
    String photo;

    // <editor-fold defaultstate="collapsed" desc="Getter and Setter for Student Class"> 
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGrandName() {
        return grandName;
    }

    public void setGrandName(String grandName) {
        this.grandName = grandName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    // </editor-fold> 

    public boolean registerStudent(Student student, int departmentCode) throws Exception {
        String sqlInsertStudent = "INSERT INTO Student(STUDENT_ID, NAME, FATHER_NAME, GRANDFATHER_NAME, SEX, DATE_OF_BIRTH, PHONE, EMAIL, STUDENT_DEPT_CODE, PHOTO)"
                + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = DbConnection.getConn();
        PreparedStatement prstStudent = conn.prepareStatement(sqlInsertStudent);
        prstStudent.setString(1, student.getStudentId());
        prstStudent.setString(2, student.getName());
        prstStudent.setString(3, student.getFatherName());
        prstStudent.setString(4, student.getGrandName());
        prstStudent.setString(5, student.getSex());
        if (student.getDateOfBirth() != null) {
            //conver date of birth string value to MySQL/Oracle date value
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfBirthFormat = dateFormatter.format(student.getDateOfBirth());
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateOfBirthFormat);
            prstStudent.setDate(6, sqlDate);
        } else {
            prstStudent.setNull(6, java.sql.Types.DATE);
        }
        prstStudent.setString(7, student.getPhone());
        prstStudent.setString(8, student.getEmail());
        prstStudent.setInt(9, departmentCode);
        InputStream photoStrem = null;
        if (student.getPhoto() != null) {
            photoStrem = new FileInputStream(new File(student.getPhoto()));
            prstStudent.setBlob(10, photoStrem);
        } else {
            prstStudent.setNull(10, java.sql.Types.BLOB);
        }
        int affectedRow = prstStudent.executeUpdate();
        return affectedRow > 0;
    }
}
