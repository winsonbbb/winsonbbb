<%-- 
    Document   : Register
    Created on : 2014/11/28, 下午 03:14:21
    Author     : chiwingkwok
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form id="form_936770" class="appnitro"  method="POST" action="registerControl?action=register">
                <div class="form_description">
                    <h2>MoreHill Pizzeria</h2>
                    <p></p>
                </div>						
                <ul >

                    <li id="li_1" >
                        <label class="description" for="element_1">Member ID  : </label>
                        <div>
                            <input id="memId" name="memId" class="element text medium" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>		<li id="li_7" >
                        <label class="description" for="element_7">Name : </label>

                        <input id="memName" name= "memName" class="element text medium" maxlength="255" value=""/>


                    </li>		<li id="li_2" >
                        <label class="description" for="element_2">Password : </label>
                        <div>
                            <input id="memPwd" name="memPwd" class="element text medium" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>		<li id="li_4" >
                        <label class="description" for="element_4">Confirm Password : </label>
                        <div>
                            <input id="element_4" name="element_4" class="element text medium" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>		<li id="li_6" >
                        <label class="description" for="element_6">Phone : </label>
                        <div>
                            <input id="memPhone" name="memPhone" class="element text medium" type="text" maxlength="255" value=""/> 
                        </div> 
                    </li>		<li id="li_5" >
                        <label class="description" for="element_5">Address : </label>
                        <div>
                            <input id="memAddress" name="memAddress" class="element text medium" type="text" maxlength="255" value=""/> 
                        </div> 
                    <li class="buttons">
                        <input type="hidden" name="form_id" value="936770" />

                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />
                    </li>
                </ul>
            </form>	
        </div>
        <img id="bottom" src="bottom.png" alt="">
    </body>
</html>
