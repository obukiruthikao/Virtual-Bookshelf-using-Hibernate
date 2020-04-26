/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shwetha
 */
public class ModifiedProfile extends HttpServlet {

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
        int s;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session= request.getSession(false);
            String user= (String)request.getParameter("user");
            String pass= (String)request.getParameter("pass");
            String email= (String)request.getParameter("email");
            String contact= (String)request.getParameter("contact");
            String address= (String)request.getParameter("address");
            session.setAttribute("user",user);
                  session.setAttribute("password",pass);
                  session.setAttribute("email",email);
                  session.setAttribute("contact",contact);
                  session.setAttribute("address",address);
                  //out.println(user+pass+email+contact+address);
            try{
            Class.forName("com.mysql.jdbc.Driver"); 
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","")) {
                    Statement st = con.createStatement();
                    String query= "update login set pass='"+pass+"',email='"+email+"',contact='"+contact+"', address='"+address+"' where user='"+user+"'";
                    //st.setString(1, user);
                    //st.setString(2, pass);
                    //st.setString(3, email);
                    //st.setString(4,contact);
                    //st.setString(5,address);
                    
                    s=st.executeUpdate(query);
                    st.close();
                }
             if(s>0)
             {out.println("<html><body><b>Successfully Modified Profile"
                        + "</b></body></html>");
            out.println("<html><body><br/><form action='Profile' method='POST'><input type='submit' value='View Changes'></form>"
                        + "</body></html>");
            out.println("<html><body><br/><a href='bookform.jsp'>Insert Book"
                        + "</a></body></html>");
            out.println("<html><body><br/><a href='viewbooks.jsp'>View books"
                        + "</a></body></html>");
            out.println("<html><body><br/><a href='login.html'>Logout"
                        + "</a></body></html>");}
             else
             {out.println("Something went wrong.");}
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
