<%-- 
    Document   : ManagerPage
    Created on : 2014/11/28, 下午 05:15:44
    Author     : chiwingkwok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MH Pizza Online Store Management</title>
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <script type="text/javascript" src="css/view.js"></script>
    </head>
    <body id="main_body">

        <img id="top" src="css/top.png" alt="">
        <div id="form_container">

            <h1><a>MoreHill Pizzeria Online Order Management System</a></h1>
            <form id="form_936770" class="appnitro"  method="post" action="">
                <div class="form_description">
                    <p></p>
                </div>
                <h3>Manager Function</h3>
                <ul >
                    <li><a href="EditFood.jsp">Add New Food</a></li>                    
                    <li><a href="handlefood?action=list">Edit Food</a></li>
                    <li><a href="AddPoint.jsp">Add Point</a></li>
                </ul>
            </form>	
        </div>
        <img id="bottom" src="css/bottom.png" alt="">
    </body>
</html>
</html>
