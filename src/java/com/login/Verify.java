/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Shwetha
 */
public class Verify extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user= request.getParameter("username");
            String pass=request.getParameter("pass");
            HttpSession session=request.getSession();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st= con.createStatement();
                String query="select * from login where user='"+user+"'";
                ResultSet rs=st.executeQuery(query);
                if(!rs.next())
                { 
                  //out.println(rs.next()); 
                  out.println("No such account exists."); 
                  out.println("<a href='index.html'>Register</a>");
                  out.println("Or, <a href='login.html'>Try again</a>");
                }
                else
                { String password=rs.getString("pass");
                  String email=rs.getString("email");
                  String contact=rs.getString("contact");
                  String address=rs.getString("address");
                  
                  if(!pass.equals(password))
                  { out.println("Incorrect password. <a href='login.html'>Try again</a>");
                  }  
                  else
                  { session.setAttribute("user",user);
                  session.setAttribute("password",password);
                  session.setAttribute("email",email);
                  session.setAttribute("contact",contact);
                  session.setAttribute("address",address);
                  response.sendRedirect("dashboard.jsp");

                 /* out.println("<html><head><style>\n" +
"table {\n" +
"  border-collapse: collapse;\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
"th, td {\n" +
"  text-align: left;\n" +
"  padding: 8px;\n" +
"}\n" +
"\n" +
"tr:nth-child(even){background-color: #f2f2f2}\n" +
"\n" +
"th {\n" +
"  background-color: #000000;\n" +
"  color: white;\n" +
"}\n" +
"</style></head><body> <center>\n" +
"\n" +
"		<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>\n" +
"<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n" +
"<div class=\"wrapper\">\n" +
"            <form action=\"bookform.jsp\" method=\"post\">\n" +
"                <input type=\"submit\" class=\"submit\" value=\"Insert Book\" name=\"read\">\n" +
"            </form> <form action=\"viewbooks.jsp\" method=\"post\">\n" +
"                <input type=\"submit\" class=\"submit\" value=\"View Books\" name=\"toread\">\n" +
"            </form>\n" +
"             <form action=\"Profile\" method=\"post\">\n" +
"                <input type=\"submit\" class=\"submit\" value=\"View Profile\" name=\"reading\">\n" +
"            </form></div></body></html>");
                      out.println("<h3>Logged in.</h3>  <a href='bookform.jsp'>Insert Book</a>");
                      out.println("<a href='viewbooks.jsp'> View Books </a>");
                      out.println("<form action='Profile' method='POST'> <input type='submit' value='View Profile'></form>");
                  }*/
                }
                }
            }
            catch(ClassNotFoundException | SQLException e){ out.println(e);}
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
