/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ChalewT
 */
public class Faculty {

    //properties/Field
    int code;
    String name;
    String phone;
    String fax;
    String email;

    public Faculty(int fcode, String fname) {
        this.code = fcode;
        this.name = fname;
    }

    public Faculty() {
    }
    //Seters and Getters

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Methods 
    public boolean registerFaculty(Faculty faculty) throws Exception {
        String sqlInsertDept = "Insert into Faculty (Faculty_Name, Faculty_Phone, Faculty_Fax,Faculty_Email) Values(?, ?, ?, ?)";
        Connection conn = DbConnection.getConn();
        PreparedStatement pstFaculty = conn.prepareStatement(sqlInsertDept);
        pstFaculty.setString(1, faculty.getName());
        pstFaculty.setString(2, faculty.getPhone());
        pstFaculty.setString(3, faculty.getFax());
        pstFaculty.setString(4, faculty.getEmail());
        int affectedRow = pstFaculty.executeUpdate();
        pstFaculty.close();
        conn.close();
        if (affectedRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Faculty> getFacultyDetail() throws Exception {
        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
        String sql = "Select * from Faculty Order By Faculty_Name ASC";
        Connection conn = DbConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            Faculty faculty = new Faculty();
            faculty.setCode(rst.getInt("Faculty_Code"));
            faculty.setName(rst.getString("Faculty_Name"));
            faculty.setPhone(rst.getString("Faculty_Phone"));
            faculty.setFax(rst.getString("Faculty_Fax"));
            faculty.setEmail(rst.getString("Faculty_Email"));
            facultyList.add(faculty);
        }
        pst.close();
        rst.close();
        conn.close();
        return facultyList;
    }

    public ArrayList<Faculty> getFacultyList() throws SQLException, ClassNotFoundException, Exception {
        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
        String sql = "Select Faculty_Code, Faculty_Name from Faculty Order By Faculty_Name ASC";
        Connection conn = DbConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            int facultyCode = rst.getInt("Faculty_Code");
            String facultyName = rst.getString("Faculty_Name");
            Faculty faculty = new Faculty(facultyCode, facultyName);
            facultyList.add(faculty);
        }
        pst.close();
        rst.close();
        conn.close();
        return facultyList;
    }

}
