<%-- 
    Document   : insert
    Created on : Mar 20, 2020, 6:03:20 AM
    Author     : Obu
--%>

<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.login.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String address = request.getParameter("address");

            
            
            Session s = NewHibernateUtil.getSessionFactory().openSession();
            Transaction trans = s.beginTransaction();
            
            Login obj = new Login();
            obj.setUser(user);
            obj.setPass(pass);
            obj.setEmail(email);
            obj.setContact(contact);
            obj.setAddress(address);
            session.setAttribute("user",user);
            session.setAttribute("email",email);
            session.setAttribute("password",pass);
            session.setAttribute("contact",contact);
            session.setAttribute("address",address);
            s.save(obj);
            trans.commit();
            s.close();
            response.sendRedirect("dashboard.jsp");
            out.println("Inserted ");
            
                    %>
            
      <a href="bookform.jsp">Insert Book</a>      
           
    </body>
</html>
