<%-- 
    Document   : newdepartment
    Created on : May 18, 2017, 6:45:54 AM
    Author     : ChalewT
--%>

<%@page import="registrarlib.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page import="registrarlib.Faculty"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Information System</title>
    </head>
    <body>
        <h1>New Department Registration</h1>
        <hr/>
        <form name="newdepartment" action="newdepartment.jsp" method="POST">
            <table border="0" align ="center">
                <tbody>
                    <tr>
                        <td align ="right">
                            College/Faculty :
                        </td>
                        <td>
                            <select id="ddlFaculty" name="ddlFaculty">
                                <%
                                    try {
                                        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
                                        Faculty faculty = new Faculty();
                                        facultyList = faculty.getFacultyList();
                                        for (Faculty facultyInList : facultyList) {
                                %>
                                <option value="<%out.print(facultyInList.getCode());%>"><%out.print(facultyInList.getName());%></option>
                                <%
                                        }
                                    } catch (Exception ex) {
                                    }
                                %>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align ="right">Department :</td>
                        <td><input type="text" name="txtName" value="" size="30" /></td>
                    </tr>
                    <tr>
                        <td align ="right">Phone :</td>
                        <td><input type="text" name="txtPhone" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td align ="right">Fax :</td>
                        <td><input type="text" name="txtFax" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td align ="right">Email :</td>
                        <td><input type="text" name="txtEmail" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> 
                            <input type="submit" value="Submit" name="btnSubmit"/>
                            <input type="reset" value="Clear" name="btnClear" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>


                            <%
                                if (request.getParameter("btnSubmit") != null) {
                                    Department dept = new Department();
                                    dept.setName(request.getParameter("txtName"));
                                    dept.setPhone(request.getParameter("txtPhone"));
                                    dept.setFax(request.getParameter("txtFax"));
                                    dept.setEmail(request.getParameter("txtEmail"));
                                    int facultyCode = Integer.parseInt(request.getParameter("ddlFaculty"));
                                    boolean saved = false;
                                    try {
                                        saved = dept.registerDepartment(dept, facultyCode);
                                    } catch (Exception ex) {
                            %>
                            <p align ="center" style="color:red"> <%= "Error occurred.\n" + ex.getMessage()%></p>
                            <%
                                }
                                if (saved == true) {
                            %>
                            <p align ="center" style="color:blue"> <%= "Registration Completed Successfully."%></p>
                            <%
                            } else {
                            %>
                            <p align ="center" style="color:red"> <%= "Registration faild. Tray again."%></p>
                            <%
                                    }
                                }
                            %>
                        </td>
                    </tr>
                </tbody>
                <table
                    </form>
                    </body>
                    </html>
