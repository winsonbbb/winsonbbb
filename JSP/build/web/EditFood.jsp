<%-- 
    Document   : EditFood
    Created on : 2014/11/29, 下午 01:53:47
    Author     : chiwingkwok
--%>
<%@page import="ict.Bean.Foodbean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Food Page</title>
    </head>
    <body>
        <jsp:useBean id="c" scope="request"  class="ict.Bean.Foodbean"/>
       <%
            String type=c.getFoodID() !=null? "edit":"add";
            String FoodID = c.getFoodID() != null ? c.getFoodID() : "";
            String FoodName = c.getFoodName() != null ? c.getFoodName() : "";
            String FoodDesc = c.getFoodDesc() != null ? c.getFoodDesc() : "";
            String FoodCate = c.getFoodCate() != null ? c.getFoodCate() : "";
            String FoodPrice = c.getFoodPrice() != 0.0 ? ""+c.getFoodPrice() : "";
        %>
        <form method=“get" action="handleFoodEdit"> 
         <input type="hidden" name="action" value="<%=type%>" /> 
         <table>
        <%
            if(type.equals("add"))
                out.println("<tr> <td>New Food ID    :</td> <td> <input name=\"foodid\" type=\"text\" value="+FoodID+"\"/></td></tr>");
            else
                out.println("<tr> <td>Food ID    :</td> <td> <input name=\"foodid\" type=\"text\" value='"+c.getFoodID()+"'/></td></tr>");
            
        %>
         
         <tr> <td>New Food Name  :</td> <td> <input name="foodname" type="text" value="<%=FoodName%>"/></td></tr>
         <tr> <td>New Food Desc  :</td> <td> <input name="fooddesc" type="text" value="<%=FoodDesc%>"/></td></tr>
         <tr> <td>New Food Cate  :</td> <td> <input name="foodcate" type="text" value="<%=FoodCate%>"/></td></tr>
         <tr> <td>New Food Price :</td> <td> <input name="foodprice" type="text" value="<%=FoodPrice%>"/></td></tr>
         <tr> <td><input type="submit" value="submit"/> </td></tr> 
         </table>
         </form>
       
    </body>
</html>
