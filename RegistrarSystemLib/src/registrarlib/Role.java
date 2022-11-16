/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ChalewT
 */
public class Role {

    int id;
    String role;
    String description;
    int status;
    Date effectiveDate;
    Date expiryDate;

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter for Account Class"> 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    //</editor-fold >
    //
    //Methods
    //
    public int assignRole(String username, int id, int status, Date effDate, Date expDate) throws Exception {
        //This code demonstrates 
        //how to call stored procedure using CallableStatement class
        Connection conn = DbConnection.getConn();
        CallableStatement callStmt = conn.prepareCall("{call SP_ASSIGN_ROLE_TO_USER(?,?,?,?,?,?)}");

        //Register OUT Parameters and pass IN Parameters
        callStmt.setString(1, username);
        callStmt.setInt(2, id);
        callStmt.setInt(3, status);
        if (effDate != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormatter.format(effDate);
            java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
            callStmt.setDate(4, sqlDate);
        } else {
            callStmt.setNull(4, java.sql.Types.DATE);
        }
        if (expDate != null) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormatter.format(expDate);
            java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);
            callStmt.setDate(5, sqlDate);
        } else {
            callStmt.setNull(5, java.sql.Types.DATE);
        }
        callStmt.registerOutParameter(6, Types.INTEGER);
        //Execute the cammand
        callStmt.executeUpdate();
        //get return value
        int returnValue = callStmt.getInt(6);
        return returnValue;
    }

    public ArrayList<Role> getRoleList() throws Exception {
        //Get/Select all roles
        ArrayList<Role> roleList = new ArrayList<Role>();
        String sql = "Select * from ROLE";
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        ResultSet rst = prst.executeQuery();
        while (rst.next()) {
            Role r = new Role();
            r.setId(rst.getInt("ROLE_ID"));
            r.setRole(rst.getString("ROLE_NAME"));
            r.setDescription(rst.getString("ROLE_DESCRIPTION"));
            roleList.add(r);
        }
        return roleList;
    }

    public ArrayList<Role> getUnAssignedRoleList(String username) throws Exception {
        ArrayList<Role> roleList = new ArrayList<Role>();
        //Get/Select roles in which a user is not a member currently 
        String sql = "SELECT ROLE_ID,ROLE_NAME, ROLE_DESCRIPTION FROM ROLE WHERE ROLE_ID NOT IN("
                + "SELECT USER_ROLE_ROLE_ID FROM USER_ROLE WHERE USER_ROLE.USER_ROLE_USERNAME=? AND USER_ROLE.ROLE_STATUS = 1 AND "
                + "(USER_ROLE.EXPIRY_DATE > SYSDATE OR USER_ROLE.EXPIRY_DATE IS NULL))";
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, username);
        ResultSet rst = prst.executeQuery();
        while (rst.next()) {
            Role r = new Role();
            r.setId(rst.getInt("ROLE_ID"));
            r.setRole(rst.getString("ROLE_NAME"));
            r.setDescription(rst.getString("ROLE_DESCRIPTION"));
            roleList.add(r);
        }
        return roleList;
    }

    public static ArrayList<String> getUserRoleList(String username) throws Exception {
        //Code to Get user roles
        ArrayList<String> userRoleList = new ArrayList<String>();
        String sql = "SELECT ROLE.ROLE_NAME, USER_ROLE.USER_ROLE_ROLE_ID FROM ROLE INNER JOIN USER_ROLE ON ROLE.ROLE_ID = USER_ROLE.USER_ROLE_ROLE_ID " +
                        " WHERE USER_ROLE.USER_ROLE_USERNAME = ? AND USER_ROLE.ROLE_STATUS = 1 AND "
                        + "(USER_ROLE.EXPIRY_DATE > SYSDATE OR USER_ROLE.EXPIRY_DATE IS NULL)";
        Connection conn = DbConnection.getConn();
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setString(1, username);
        ResultSet rst = prst.executeQuery();
        while(rst.next()){
            userRoleList.add(rst.getString("ROLE_NAME"));
        }
        return userRoleList;
    }

}
