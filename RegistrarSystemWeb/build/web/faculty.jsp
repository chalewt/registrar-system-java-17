<%-- 
    Document   : faculty
    Created on : May 13, 2017, 4:28:35 PM
    Author     : ChalewT
--%>

<%@page import="registrarlib.Faculty"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Information</title>
    </head>
    <body>
        <div style="background-color: background">
            <h1 align ="center" style="color:blue">Web-Based Registrar Information System</h1>
            <hr/>
        </div
        <div class="register">
            <h3 align ="center" style="color:green">Faculty Registration Form</h3>
            <hr/>
            <form name="registerForm" action="faculty.jsp" method="POST">
                <table border="0" align ="center">
                    <tbody>
                        <tr>
                            <td align ="right">College/Faculty :</td>
                            <td><input type="text" name="txtName" value="" size="40" /></td>
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
                    </tbody>
                </table>
                <%
                    if (request.getParameter("btnSubmit") != null) {
                        Faculty faculty = new Faculty();
                        faculty.setName(request.getParameter("txtName"));
                        faculty.setPhone(request.getParameter("txtPhone"));
                        faculty.setFax(request.getParameter("txtFax"));
                        faculty.setEmail(request.getParameter("txtEmail"));
                        boolean saved = false;
                        try {
                            saved = faculty.registerFaculty(faculty);
                        } catch (Exception ex) {
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
            </form>
        </div>
        <div class="display">
            <h3 align ="center" style="color:green">Faculty information</h3>
            <hr/>
            <table border="1" align ="center">
                <form action="faculty.jsp">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Code</th>
                            <th>College/Faculty</th>
                            <th>Phone</th>
                            <th>Fax</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <%
                        Faculty faculty = new Faculty();
                        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
                        try {
                            facultyList = faculty.getFacultyDetail();
                        } catch (Exception ex) {
                    %>
                    <p align ="center" style="color:red"> <%= "Error Occurred.\n" + ex.getMessage()%></p>
                    <%
                        }
                        int sNo = 0;
                        for (Faculty fInList : facultyList) {
                            sNo++;
                    %>
                    <tbody>
                        <tr>
                            <td><%=sNo%></td>
                            <td><%=fInList.getCode()%></td>
                            <td><%=fInList.getName()%></td>
                            <td><%=fInList.getPhone()%></td>
                            <td><%= fInList.getFax()%></td>
                            <td><%= fInList.getEmail()%></td>
                        </tr>
                    </tbody>
                    <%
                        }
                    %>
                </form>
            </table>
        </div>
    </body>
</html>
