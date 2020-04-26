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
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shwetha
 */
public class UpdatedBook extends HttpServlet {

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
            String pass= (String)session.getAttribute("pass");
            String email= (String)session.getAttribute("email");
            String contact= (String)session.getAttribute("contact");
            String address= (String)session.getAttribute("address");
                  session.setAttribute("user",user);
                  session.setAttribute("password",pass);
                  session.setAttribute("email",email);
                  session.setAttribute("contact",contact);
                  session.setAttribute("address",address);
            String book= request.getParameter("book");
            String author=request.getParameter("author");
            String pages=request.getParameter("pages");
            String pageno=request.getParameter("pageno");
            String category=request.getParameter("category");
            int pg= Integer.parseInt(pageno);
            int pgs=Integer.parseInt(pages);
            if(pg==pgs)
                category="read";
            else if(pg>0)
                category="reading";
            else if(pg==0)
                category="toread";
            try{
            Class.forName("com.mysql.jdbc.Driver");
            if(pg>pgs)
            { out.println("Error, page number exceeds number of pages");
              out.println("<html><body><form action='ListBooks' method='POST'><input type='submit' value='Try again'></form></body></html>");
            }
            else{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",""); 
        PreparedStatement st = con.prepareStatement("update book set author='"+author+"', pages='"+pages+"', pageno='"+pageno+"', category='"+category+"' where book='"+book+"'"); 
        
         st.executeUpdate(); 
        st.close(); 
            con.close();
            out.println("<html><head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">");
            out.println("<style>\n.material-icons {vertical-align:-14%}" +
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
         out.println("</head><body>");
          out.println("            <center>\n" +
"\n" +
"		<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>\n" +
"<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n" +
"<div class=\"wrapper\">");
      out.println("            <p><a href=\"dashboard.jsp\"><button class=\"w3-btn w3-orange w3-xlarge\">Home<i class=\"w3-margin-left material-icons\">home</i></button></a></p>\n" +
"");
            out.println("<h2 style='color:white'><b>Successfully Updated"
                        + "</b></h2>");
            out.println("<br/><form action='ListBooks' method='POST'> <input type='submit' class='submit' value='Update another book'></form>");
            out.println("<br/><form acion='bookform.jsp' method='POST'><input type='submit' class='submit' value='Insert another book'></form>");
                        
            out.println("<br/><form action='viewbooks.jsp' method='POST'><input type='submit' class='submit' value='View books'></form>");
       
            out.println("<br/><form action='login.html' method='POST'><input type='submit' class='submit' value='Logout'></form>");
            out.println("</div></body></html>");
            }}
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
