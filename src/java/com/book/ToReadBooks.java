/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Obu
 */
@WebServlet(name = "ToReadBooks", urlPatterns = {"/ToReadBooks"})
public class ToReadBooks extends HttpServlet {

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
          HttpSession session= request.getSession(false);
            String user= (String)session.getAttribute("user");
            String pass= (String)session.getAttribute("pass");
            String email= (String)session.getAttribute("email");
            String contact= (String)session.getAttribute("contact");
            String address= (String)session.getAttribute("address");
                  session.setAttribute("user",user);
                  session.setAttribute("password",pass);
                  session.setAttribute("email",email);
                  session.setAttribute("contact",contact);
                  session.setAttribute("address",address);
                  
            try{
            Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM book WHERE category='toread' AND user='"+user+"'";
        ResultSet rs = stmt.executeQuery(sql);
        out.println("<html><head><style><style>\n" +
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
"</style></head><body><table><tr><th>Book</th><th>Author</th><th>Pages</th><th>Pages Read</th></tr>");
      
        while(rs.next()){
         //Retrieve by column name
         String book  = rs.getString("book");
         String author = rs.getString("author");
         int pages = rs.getInt("pages");
         int pageno = rs.getInt("pageno");

         //Display values
         //Display values
          out.println("<tr>\n" +
"    <td>"+book+"</td>\n" +
"    <td>"+author+"</td>\n" +
"    <td>"+pages+"</td>\n" +
"    <td>"+pageno+"</td>\n" +
"  </tr>");
      }
        out.println("</table></body></html>");
        rs.close();
        
        out.println("<html><body bgcolor=40E0D0><b>Successfully Fetched"
                        + "</b><br/><br/><a href='bookform.jsp'>Insert another book</a><br/>"
                    + "<a href='viewbooks.jsp'>View books</a><br/>"
                    + "<a href='login.html'>Logout</a></br>"
                    + "</body></html>");
            }
            catch(Exception e){ out.println(e);}

        
        
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
