<%-- 
    Document   : loginError
    Created on : Nov 6, 2014, 3:47:38 PM
    Author     : Tak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Error</title>
    </head>
    <body>
        <p>incorrect Password</p>
        <p>
            <% out.println("<a href=\"" + request.getContextPath() + "/main\">Login again </a>");%>
        </p>
    </body>
</html>
