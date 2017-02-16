<%-- 
    Document   : AddPoint
    Created on : 2014/12/1, 上午 10:53:46
    Author     : chiwingkwok
--%>
<%@page import="ict.Bean.MemberBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form method=“get" action="AddPoints"> 
         <input type="hidden" name="action" value="add" /> 
         <table>
    <input name="memberid" type="text"/>
         
         <tr> <td>Add MemberPoint :</td> <td> <input name="memberpoint" type="text"/></td></tr>
         <tr> <td><input type="submit" value="submit"/> </td></tr> 
         </table>
         </form>
    </body>
</html>



       
       
    </body>
</html>
