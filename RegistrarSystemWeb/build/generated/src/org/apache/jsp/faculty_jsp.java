package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import registrarlib.Faculty;
import java.util.ArrayList;

public final class faculty_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Faculty Information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"background-color: background\">\n");
      out.write("            <h1 align =\"center\" style=\"color:blue\">Web-Based Registrar Information System</h1>\n");
      out.write("            <hr/>\n");
      out.write("        </div\n");
      out.write("        <div class=\"register\">\n");
      out.write("            <h3 align =\"center\" style=\"color:green\">Faculty Registration Form</h3>\n");
      out.write("            <hr/>\n");
      out.write("            <form name=\"registerForm\" action=\"faculty.jsp\" method=\"POST\">\n");
      out.write("                <table border=\"0\" align =\"center\">\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align =\"right\">College/Faculty :</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtName\" value=\"\" size=\"40\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align =\"right\">Phone :</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtPhone\" value=\"\" size=\"20\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align =\"right\">Fax :</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtFax\" value=\"\" size=\"20\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align =\"right\">Email :</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtEmail\" value=\"\" size=\"20\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td> \n");
      out.write("                                <input type=\"submit\" value=\"Submit\" name=\"btnSubmit\"/>\n");
      out.write("                                <input type=\"reset\" value=\"Clear\" name=\"btnClear\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("                <p align =\"center\" style=\"color:blue\"> ");
      out.print( "Registration Completed Successfully.");
      out.write("</p>\n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <p align =\"center\" style=\"color:red\"> ");
      out.print( "Registration faild. Tray again.");
      out.write("</p>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"display\">\n");
      out.write("            <h3 align =\"center\" style=\"color:green\">Faculty information</h3>\n");
      out.write("            <hr/>\n");
      out.write("            <table border=\"1\" align =\"center\">\n");
      out.write("                <form action=\"faculty.jsp\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>No</th>\n");
      out.write("                            <th>Code</th>\n");
      out.write("                            <th>College/Faculty</th>\n");
      out.write("                            <th>Phone</th>\n");
      out.write("                            <th>Fax</th>\n");
      out.write("                            <th>Email</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    ");

                        Faculty faculty = new Faculty();
                        ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
                        try {
                            facultyList = faculty.getFacultyDetail();
                        } catch (Exception ex) {
                    
      out.write("\n");
      out.write("                    <p align =\"center\" style=\"color:red\"> ");
      out.print( "Error Occurred.\n" + ex.getMessage());
      out.write("</p>\n");
      out.write("                    ");

                        }
                        int sNo = 0;
                        for (Faculty fInList : facultyList) {
                            sNo++;
                    
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(sNo);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(fInList.getCode());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(fInList.getName());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(fInList.getPhone());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( fInList.getFax());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( fInList.getEmail());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
