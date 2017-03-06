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
        <title>Write a Posts</title>
    </head>
    <body>
        <h1>Write a Posts</h1>

        <form method="post" action="addposts">
            <label for="post">Post</label>
            <br>
            <br>
            <textarea name="post" cols="15" rows="20"></textarea>
            <br>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
