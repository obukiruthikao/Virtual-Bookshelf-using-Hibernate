<%-- 
    Document   : deleteprofile
    Created on : 22 Apr, 2020, 9:19:21 AM
    Author     : Shwetha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <script>
            alert("Note: Deleting your account automatically removes all associated information from our servers.");
            </script>
        <h1> Warning! Are you sure you want to delete your account? This action cannot be undone. </h1>
        
        <form action="DeleteProfile" method="POST">
            <input type="submit" value="Yes, Delete my account">
        </form>
        <form action="Profile" method="POST">
            <input type="submit" value="No, Go back">
        </form>
        
    </body>
</html>
