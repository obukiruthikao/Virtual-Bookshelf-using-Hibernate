/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shwetha
 */
public class ModifyProfile extends HttpServlet {

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
            HttpSession session= request.getSession(false);
             String user= (String)session.getAttribute("user");
            String pass=(String)session.getAttribute("password");
            String email=(String)session.getAttribute("email");
            String contact=(String)session.getAttribute("contact");
            String address=(String)session.getAttribute("address");
            session.setAttribute("user",user);
                  session.setAttribute("pass",pass);
                  session.setAttribute("email",email);
                  session.setAttribute("contact",contact);
                  session.setAttribute("address",address);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Profile</title>");  
            out.println("<style>\n" +
"		/*dark background to support form theme*/\n" +
"body{\n" +
"  background:url(http://subtlepatterns2015.subtlepatterns.netdna-cdn.com/patterns/dark_wall.png);;\n" +
"}\n" +
"\n" +
"/*sass variables used*/\n" +
"\n" +
"\n" +
"\n" +
"/*site container*/\n" +
".wrapper{\n" +
"  width:420px;\n" +
"  margin:0 auto;\n" +
"}\n" +
"\n" +
"h1{\n" +
"  text-align:center;\n" +
"  padding:30px 0px 0px 0px;\n" +
"  font:25px Oswald;\n" +
"  color:#FFF;\n" +
"  text-transform:uppercase;\n" +
"  text-shadow:#000 0px 1px 5px;\n" +
"  margin:0px;\n" +
"}\n" +
"\n" +
"p{\n" +
"  font:13px Open Sans;\n" +
"  color:#6E6E6E;\n" +
"  text-shadow:#000 0px 1px 5px;\n" +
"  margin-bottom:30px;\n" +
"}\n" +
"\n" +
".form{\n" +
"  width:100%;\n" +
"}\n" +
"\n" +
"input[type=\"text\"],input[type=\"email\"]{\n" +
"  width:98%;\n" +
"  padding:15px 0px 15px 8px;\n" +
"  border-radius:5px;\n" +
"  box-shadow:inset 4px 6px 10px -4px rgba(0,0,0,0.3), 0 1px 1px -1px rgba(255,255,255,0.3);\n" +
"	background:rgba(0,0,0,0.2);\n" +
"  \n" +
"  border:1px solid rgba(0,0,0,1);\n" +
"  margin-bottom:10px;\n" +
"  color:#6E6E6E;\n" +
"  text-shadow:#000 0px 1px 5px;\n" +
"}\n" +
"\n" +
"input[type=\"submit\"]{\n" +
"  width:100%;\n" +
"  padding:15px;\n" +
"  border-radius:5px;\n" +
"\n" +
"  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#28D2DE), to(#1A878F));\n" +
"  background-image: -webkit-linear-gradient(#28D2DE 0%, #1A878F 100%);\n" +
"  background-image: -moz-linear-gradient(#28D2DE 0%, #1A878F 100%);\n" +
"  background-image: -o-linear-gradient(#28D2DE 0%, #1A878F 100%);\n" +
"  background-image: linear-gradient(#28D2DE 0%, #1A878F 100%);\n" +
"  font:14px Oswald;\n" +
"  color:#FFF;\n" +
"  text-transform:uppercase;\n" +
"  text-shadow:#000 0px 1px 5px;\n" +
"  border:1px solid #000;\n" +
"  opacity:0.7;\n" +
"	-webkit-box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);\n" +
"  -moz-box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);\n" +
"	box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);\n" +
"  border-top:1px solid rgba(255,255,255,0.8)!important;\n" +
"  -webkit-box-reflect: below 0px -webkit-gradient(linear, left top, left bottom, from(transparent), color-stop(50%, transparent), to(rgba(255,255,255,0.2)));\n" +
"}\n" +
"\n" +
"input:focus{\n" +
"  box-shadow:inset 4px 6px 10px -4px rgba(0,0,0,0.7), 0 1px 1px -1px rgba(255,255,255,0.3);\n" +
"  background:rgba(0,0,0,0.3);\n" +
" \n" +
"}\n" +
"\n" +
"input[type=\"submit\"]:hover{\n" +
"  opacity:1;\n" +
"  cursor:pointer;\n" +
"}\n" +
"\n" +
".name-help,.email-help{\n" +
"  display:none;\n" +
"  padding:0px;\n" +
"  margin:0px 0px 15px 0px;\n" +
"}\n" +
"\n" +
".optimize{\n" +
"  position:fixed;\n" +
"  right:3%;\n" +
"  top:0px;\n" +
"}\n" +
"</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Profile</h1>");
             out.println("            <center>\n" +
"\n" +
"		<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>\n" +
"<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n" +
"<div class=\"wrapper\">");
            out.println("<form action='ModifiedProfile' method='POST'>");       
            out.println("<h3 style='color:white;'>Username:</h3><input type='text' class='name' name='user' value='"+user+"' readonly>");
            out.println("<h3 style='color:white;'>Password:</h3><input type='text'  class='name' name='pass' value='"+pass+"' required>");
            out.println("<h3 style='color:white;'>Email:</h3><input type='text' class='name' name='email' value='"+email+"' required>");
            out.println("<h3 style='color:white;'>Contact:</h3><input type='text' class='name' name='contact' value='"+contact+"' required>");
            out.println("<h3 style='color:white;'>Address:</h3><input type='textarea' class='name' name='address' value='"+address+"' required>");
            out.println("<input type='submit' class='submit' value='Modify Profile'></form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
