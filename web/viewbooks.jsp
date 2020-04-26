<%-- 
    Document   : viewbooks
    Created on : Mar 24, 2020, 3:15:33 PM
    Author     : Obu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>JSP Page</title>
        <style>
                    .material-icons {vertical-align:-14%}

		/*dark background to support form theme*/
body{
  background:url(http://subtlepatterns2015.subtlepatterns.netdna-cdn.com/patterns/dark_wall.png);;
}

/*sass variables used*/



/*site container*/
.wrapper{
  width:420px;
  margin:0 auto;
}

h1{
  text-align:center;
  padding:30px 0px 0px 0px;
  font:25px Oswald;
  color:#FFF;
  text-transform:uppercase;
  text-shadow:#000 0px 1px 5px;
  margin:0px;
}

p{
  font:13px Open Sans;
  color:#6E6E6E;
  text-shadow:#000 0px 1px 5px;
  margin-bottom:30px;
}

.form{
  width:100%;
}

input[type="text"],input[type="email"]{
  width:98%;
  padding:15px 0px 15px 8px;
  border-radius:5px;
  box-shadow:inset 4px 6px 10px -4px rgba(0,0,0,0.3), 0 1px 1px -1px rgba(255,255,255,0.3);
	background:rgba(0,0,0,0.2);
  
  border:1px solid rgba(0,0,0,1);
  margin-bottom:10px;
  color:#6E6E6E;
  text-shadow:#000 0px 1px 5px;
}

input[type="submit"]{
  width:100%;
  padding:15px;
  border-radius:5px;

  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#28D2DE), to(#1A878F));
  background-image: -webkit-linear-gradient(#28D2DE 0%, #1A878F 100%);
  background-image: -moz-linear-gradient(#28D2DE 0%, #1A878F 100%);
  background-image: -o-linear-gradient(#28D2DE 0%, #1A878F 100%);
  background-image: linear-gradient(#28D2DE 0%, #1A878F 100%);
  font:14px Oswald;
  color:#FFF;
  text-transform:uppercase;
  text-shadow:#000 0px 1px 5px;
  border:1px solid #000;
  opacity:0.7;
	-webkit-box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);
  -moz-box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);
	box-shadow: 0 8px 6px -6px rgba(0,0,0,0.7);
  border-top:1px solid rgba(255,255,255,0.8)!important;
  -webkit-box-reflect: below 0px -webkit-gradient(linear, left top, left bottom, from(transparent), color-stop(50%, transparent), to(rgba(255,255,255,0.2)));
}

input:focus{
  box-shadow:inset 4px 6px 10px -4px rgba(0,0,0,0.7), 0 1px 1px -1px rgba(255,255,255,0.3);
  background:rgba(0,0,0,0.3);
 
}

input[type="submit"]:hover{
  opacity:1;
  cursor:pointer;
}

.name-help,.email-help{
  display:none;
  padding:0px;
  margin:0px 0px 15px 0px;
}

.optimize{
  position:fixed;
  right:3%;
  top:0px;
}
</style>
    </head>
    <body>
        <%
            String user = session.getAttribute("user").toString();
            String pass = session.getAttribute("password").toString();
            String email = session.getAttribute("email").toString();
            String contact = session.getAttribute("contact").toString();
            String address = session.getAttribute("address").toString();
            out.println("<h1>Welcome, "+user+"</h1>");
            session.setAttribute("user",user);
            session.setAttribute("pass",pass);
            session.setAttribute("email",email);
            session.setAttribute("contact",contact);
            session.setAttribute("address",address);
            %>
                        <p><a href="dashboard.jsp"><button class="w3-btn w3-orange w3-xlarge">Home<i class="w3-margin-left material-icons">home</i></button></a></p>

            <center>

		<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<div class="wrapper">
            <form action="ReadBooks" method="post">
                <input type="submit" class="submit" value="Read" name="read">
            </form>
             <form action="ToReadBooks" method="post">
                <input type="submit" class="submit" value="To Read" name="toread">
            </form>
             <form action="ReadingBooks" method="post">
                <input type="submit" class="submit" value="Reading" name="reading">
            </form>
</div>
<p style="color:white"><a href="login.html">Logout</a></p>
    </body>
</html>
