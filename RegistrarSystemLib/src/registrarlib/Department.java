/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ChalewT
 */
public class Department {

    //fields
    int code;
    String name;
    String phone;
    String fax;
    String email;

    private Department(int deptCode, String deptName) {
        this.code = deptCode;
        this.name = deptName;
    }

    public Department() {
    }

    //Properties setters and Getters <Auto generated>
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Mehtods
    public boolean registerDepartment(Department dept, int facultyCode) throws Exception {
        String sqlInsertDept = "Insert into Department (Dept_Name, Dept_Phone, Dept_Fax,Dept_Email, Dept_Faculty_Code) Values(?, ?, ?, ?, ?)";
        Connection conn = DbConnection.getConn();
        PreparedStatement pstDept = conn.prepareStatement(sqlInsertDept);
        pstDept.setString(1, dept.getName());
        pstDept.setString(2, dept.getPhone());
        pstDept.setString(3, dept.getFax());
        pstDept.setString(4, dept.getEmail());
        pstDept.setInt(5, facultyCode);
        int affectedRow = pstDept.executeUpdate();
        if (affectedRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Department> getDepartmentList(int facultyCode) throws Exception {
        ArrayList<Department> deptList = new ArrayList<Department>();
        String sql = "Select Dept_Code, Dept_Name from Department where DEPT_FACULTY_CODE = ? Order By Dept_Name ASC";
        Connection conn = DbConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, facultyCode);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            int deptCode = rst.getInt("Dept_Code");
            String deptName = rst.getString("Dept_Name");
            Department dept = new Department(deptCode, deptName);
            deptList.add(dept);
        }
        pst.close();
        rst.close();
        conn.close();
        return deptList;
    }
    
     public ArrayList<Department> getDepartmentList() throws Exception {
        ArrayList<Department> deptList = new ArrayList<Department>();
        String sql = "Select Dept_Code, Dept_Name from Department Order By Dept_Name ASC";
        Connection conn = DbConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        while (rst.next()) {
            int deptCode = rst.getInt("Dept_Code");
            String deptName = rst.getString("Dept_Name");
            Department dept = new Department(deptCode, deptName);
            deptList.add(dept);
        }
        pst.close();
        rst.close();
        conn.close();
        return deptList;
    }
}
