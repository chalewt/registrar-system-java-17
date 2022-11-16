/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ChalewT
 */
public class DbConnection {
    
     public static Connection getConn() throws SQLException, ClassNotFoundException {
        //**** Oracle Connection ****//
        Class.forName("oracle.jdbc.driver.OracleDriver");//optional in the new version of java(1.4 later)
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        //**** MySql Connection ****//
        //Class.forName("com.mysql.jdbc.Driver");//optional in the new version of java(1.4 later)
        //String dbUrl = "jdbc:mysql://localhost:3036/Registrar";
        //
        String dbUser = "Registrar";
        String dbPass = "1234";
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        return conn;
    }
}
