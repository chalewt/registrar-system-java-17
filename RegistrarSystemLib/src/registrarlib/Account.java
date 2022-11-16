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
public class Account extends Employee {

    int userId;
    String username;
    String password;
    int status;
    //
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter for Account Class">

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //</editor-fold>
    //Methods

    public static boolean createAccount(String sEmpId, String sUsername, String sPassword, int iStatus) throws Exception {
        String sqlInsertAccount = "Insert into User_Account(USER_EMP_ID, USERNAME, PASSWORD, STATUS) Values(?,?,?,?)";
        Connection conn = DbConnection.getConn();
        PreparedStatement prstAccount = conn.prepareStatement(sqlInsertAccount);
        prstAccount.setString(1, sEmpId);
        prstAccount.setString(2, sUsername);
        prstAccount.setString(3, sPassword);
        prstAccount.setInt(4, iStatus);
        int affectedRow = prstAccount.executeUpdate();
        return affectedRow > 0;
    }

    public static boolean login(String sUsername, String sPassword) throws Exception {
        String sqlSelectAccount = "Select USERNAME from User_Account Where USERNAME = ? AND PASSWORD =? AND STATUS=1";
        Connection conn = DbConnection.getConn();
        PreparedStatement prstAccount = conn.prepareStatement(sqlSelectAccount);
        prstAccount.setString(1, sUsername);
        prstAccount.setString(2, sPassword);
        ResultSet rstAccount = prstAccount.executeQuery();
        return rstAccount.next();
    }

    public ArrayList<Account> getUserAccountList() throws Exception {
        ArrayList<Account> accountList = new ArrayList<Account>();
        String sql = "Select * from VIEW_USER_ACCOUNT";
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        ResultSet rst = prst.executeQuery();
        while (rst.next()) {
            Account accData = new Account();
            accData.setEmployeeId(rst.getString("EMPLOYEE_ID"));
            accData.setUsername(rst.getString("USERNAME"));
            accData.setName(rst.getString("NAME"));
            accData.setFatherName(rst.getString("FATHER_NAME"));
            accData.setGrandfatherName(rst.getString("GRANDFATHER_NAME"));
            accData.setSex(rst.getString("SEX"));
            accData.setPhone(rst.getString("PHONE"));
            accData.setEmail(rst.getString("EMAIL"));
            accData.setStatus(rst.getInt("STATUS"));
            accountList.add(accData);
        }
        return accountList;
    }

    public Account getUserAccount(String sEmpId, String sUsername) throws Exception {
        Account accData = new Account();
        String sql = "";
        if (!"".equals(sEmpId)) {
            sql = "Select * from VIEW_USER_ACCOUNT where EMPLOYEE_ID=?";
        } else {
            sql = "Select * from VIEW_USER_ACCOUNT where USERNAME=?";
        }
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        if (!"".equals(sEmpId)) {
            prst.setString(1, sEmpId);
        } else {
            prst.setString(1, sUsername);
        }
        ResultSet rst = prst.executeQuery();
        if (rst.next()) {
            accData.setEmployeeId(rst.getString("EMPLOYEE_ID"));
            accData.setUsername(rst.getString("USERNAME"));
            accData.setName(rst.getString("NAME"));
            accData.setFatherName(rst.getString("FATHER_NAME"));
            accData.setGrandfatherName(rst.getString("GRANDFATHER_NAME"));
            accData.setSex(rst.getString("SEX"));
            accData.setPhone(rst.getString("PHONE"));
            accData.setEmail(rst.getString("EMAIL"));
            accData.setStatus(rst.getInt("STATUS"));
        } else {
            accData = null;
        }
        return accData;
    }

    public boolean changePassword(String uname, String currPass, String newPass) throws Exception{
        String sql ="Update USER_ACCOUNT SET PASSWORD=? Where USERNAME = ? AND PASSWORD = ?";
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, newPass);
        prst.setString(2, uname);
        prst.setString(3, currPass);
        int ar = prst.executeUpdate();
        return ar>0;
    }
    
}
