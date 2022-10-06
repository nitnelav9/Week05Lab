<%-- 
    Document   : login
    Created on : 5-Oct-2022, 12:08:19 PM
    Author     : valentinmorales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyLogin Welcome Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="name" value="${name}"><br>
            Password: <input type="password" name="password" value="${password}"><br>
            <input type="submit" value="Submit">
            <p>${message}</p>
        </form>
    </body>
</html>
