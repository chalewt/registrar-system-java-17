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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ChalewT
 */
public class Employee {

    String employeeId;
    String name;
    String fatherName;
    String grandfatherName;
    String sex;
    Date dateOfBirth;
    Date hiredDate;
    String phone;
    String email;
    String photo;
    //
    // <editor-fold defaultstate="collapsed" desc="Getter and Setter for Employee Class"> 
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getGrandfatherName() {
        return grandfatherName;
    }

    public void setGrandfatherName(String grandfatherName) {
        this.grandfatherName = grandfatherName;
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

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
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
    //Mehtods
    public boolean registerEmployee(Employee empData, int departmentCode) throws Exception {
          String sqlInsertEmployee = "INSERT INTO EMPLOYEE(EMPLOYEE_ID, NAME, FATHER_NAME, GRANDFATHER_NAME, SEX, "
                  + "DATE_OF_BIRTH, HIRED_DATE, PHONE, EMAIL, EMP_DEPT_CODE, PHOTO)"
                + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = DbConnection.getConn();
        PreparedStatement prstEmployee = conn.prepareStatement(sqlInsertEmployee);
        prstEmployee.setString(1, empData.getEmployeeId());
        prstEmployee.setString(2, empData.getName());
        prstEmployee.setString(3, empData.getFatherName());
        prstEmployee.setString(4, empData.getGrandfatherName());
        prstEmployee.setString(5, empData.getSex());
        if (empData.getDateOfBirth() != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfBirthFormat = dateFormatter.format(empData.getDateOfBirth());
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateOfBirthFormat);
            prstEmployee.setDate(6, sqlDate);
        } else {
            prstEmployee.setNull(6, java.sql.Types.DATE);
        }
        if (empData.getHiredDate() != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String hiredDateFormat = dateFormatter.format(empData.getHiredDate());
            java.sql.Date sqlDate = java.sql.Date.valueOf(hiredDateFormat);
            prstEmployee.setDate(7, sqlDate);
        } else {
            prstEmployee.setNull(7, java.sql.Types.DATE);
        }
        prstEmployee.setString(8, empData.getPhone());
        prstEmployee.setString(9, empData.getEmail());
        prstEmployee.setInt(10, departmentCode);
        InputStream photoStrem = null;
        if (empData.getPhoto() != null) {
            photoStrem = new FileInputStream(new File(empData.getPhoto()));
            prstEmployee.setBlob(11, photoStrem);
        } else {
            prstEmployee.setNull(11, java.sql.Types.BLOB);
        }
        int affectedRow = prstEmployee.executeUpdate();
        return affectedRow > 0;
    }
    
    public Employee searchEmployee(String empId) throws Exception{
        Employee empData = new Employee();
        
        String sql = "Select EMPLOYEE_ID, NAME, FATHER_NAME from EMPLOYEE where EMPLOYEE_ID=?";
        Connection conn = DbConnection.getConn();
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, empId);
        ResultSet r = p.executeQuery();
        if(r.next()){
            empData.setEmployeeId(r.getString("EMPLOYEE_ID"));
            empData.setName(r.getString("NAME"));
            empData.setFatherName(r.getString("FATHER_NAME"));
        }
        else{
            empData = null;
        }
        return empData;
    }

}
