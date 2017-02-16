<%-- 
    Document   : index
    Created on : 2014/11/28, 下午 02:01:06
    Author     : chiwingkwok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MoreHill Pizzeria</title>
        <link rel="stylesheet" type="text/css" href="css/view.css" media="all">
        <script type="text/javascript" src="css/view.js"></script>

    </head>
    <body id="main_body" >

        <img id="top" src="css/top.png" alt="">
        <div id="form_container">

            <h1><a>MoreHill Pizzeria</a></h1> 
            <form id="form_936770" class="appnitro"  method="post" action="main">
                <input type="hidden" name="action" value="authenticate"/>
                <div class="form_description">
                    <h2>MoreHill Pizzeria</h2>
                    <p></p>
                </div>						
                <ul >

                    <li id="li_1" >
                        <label class="description" for="element_1">Login Name : </label>
                        <div>
                            <input id="element_1" name="element_1" class="element text medium" placeholder="LoginName" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>		<li id="li_2" >
                        <label class="description" for="element_2">Password  : </label>
                        <div>
                            <input id="element_2" name="element_2" class="element text medium" placeholder="Password" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>
                    <li class="buttons">
                        <input type="hidden" name="form_id" value="936770" />
                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
                    </li>
                    <li class="buttons">
                        <input type="hidden" name="form_id" value="936770" />
                        <a href = "Register.jsp"><input id="saveForm" class="button_text" type="button" name="register" value="Register"/></a> 
                    </li>
                    <li><a href = "managerLogin.jsp">Manager</a></li>
                </ul>
            </form>	
            
        </div>
        <img id="bottom" src="css/bottom.png" alt="">
    </body>
</html>
