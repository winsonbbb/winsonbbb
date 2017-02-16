<%-- 
    Document   : ManagListFood
    Created on : 2014/11/30, 上午 02:57:53
    Author     : chiwingkwok
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.Bean.Foodbean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
            ArrayList<Foodbean> foods 
                    = (ArrayList<Foodbean>) request.getAttribute("nfoods");
            out.println("<h1>Foods</h1>");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>FoodID</th> <th> FoodName</th><th> FoodDesc</th><th> FoodCate</th ><th> FoodPrice</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record 
           for (int i = 0; i < foods.size(); i++) {
                Foodbean c = foods.get(i);
                out.println("<tr>");
                out.println("<td>" + c.getFoodID() + "</td>");
                out.println("<td>" + c.getFoodName() + "</td>");
                out.println("<td>" + c.getFoodDesc() + "</td>");
                out.println("<td>" + c.getFoodCate() + "</td>");
                out.println("<td>" + c.getFoodPrice() + "</td>"); 
                out.println("<td><a href=\"handlefood?action=delete&id="+c.getFoodID()+"\">delete</a>");
                out.println("<td><a href=\"handlefood?action=getEidtFood&id="+c.getFoodID()+"\">edit</a>");
                out.println("</tr>");
            }
            out.println("</table>");
        %>
    </body>
</html>
