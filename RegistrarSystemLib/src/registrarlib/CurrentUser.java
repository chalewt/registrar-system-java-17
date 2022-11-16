/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrarlib;

import java.util.ArrayList;

/**
 *
 * @author ChalewT
 */
public class CurrentUser {

    static String currentUsername;
    static String currentPassword;
    static boolean loggedin;
    static ArrayList<String> currentRoles;

    //
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter for CurrentUser Class">
    public static String getCurrentUsername() {
        return currentUsername;
    }

    public static void setCurrentUsername(String currentUsername) {
        CurrentUser.currentUsername = currentUsername;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void setCurrentPassword(String currentPassword) {
        CurrentUser.currentPassword = currentPassword;
    }

    public static boolean isLoggedin() {
        return loggedin;
    }

    public static void setLoggedin(boolean loggedin) {
        CurrentUser.loggedin = loggedin;
    }

    public static ArrayList<String> getCurrentRoles() {
        return currentRoles;
    }

    public static void setCurrentRoles(ArrayList<String> currentRoles) {
        CurrentUser.currentRoles = currentRoles;
    }
    //</editor-fold>

    public static boolean hasRole(String role) {

        for (String currRole : CurrentUser.getCurrentRoles()) {
            if (currRole.equals(role)) {
                return true;
            }
        }
        return false;
    }
}
