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
public class ResetPassword extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
           String pass= request.getParameter("pass");
           String pass1=request.getParameter("pass1");
           String user=request.getParameter("uname");
           try
           {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
               Statement st= con.createStatement();
               String query="select * from login where user='"+user+"'";
               ResultSet rs=st.executeQuery(query);
               if(!pass.equals(pass1))
               {
                   out.println("Passwords do not match.<a href='forgotpassword.jsp'>Try again</a>");
                   out.println("Or, <a href='index.html'>Register</a>");
                   
               }
               else{
                   
               if(!rs.next())
                { out.println("No such account exists."); 
                  out.println("<a href='index.html'>Register</a>");
                  out.println("Or, <a href='forgotpassword.jsp'>Try again</a>");
                }
               else
               {
                 String q="update login set pass='"+pass+"' where user='"+user+"'";
                 int n=st.executeUpdate(q);
                 if(n>0) 
                 {
                     out.println("Updated successfully");
                     out.println("<a href='login.html'>Login</a>");
                 } 
                 else
                 {out.println("Some error occurred");}
               }
               }
           }
           catch(ClassNotFoundException | SQLException e){out.println(e);}
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
