<%--
    Document   : login
    Created on : Mar 4, 2017, 4:38:07 PM
    Author     : Jesus Arredondo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="Forum">
            <h1>Login to the Forum</h1>
            <label for="username">User Name</label>
            <input type="text" name="username" id="username">
            <br>
            <label for="password">Password</label>
            <input type="password" name="password" id="password">
            <br>
            <br>
            <br>
            <input type="submit" name="submit" value="Submit">
        </form>

    </body>
</html>
