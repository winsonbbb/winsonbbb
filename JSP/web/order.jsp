<%-- 
    Document   : order
    Created on : Dec 1, 2014, 2:02:39 AM
    Author     : Tak
--%>

<%@page import="ict.Bean.Foodbean"%>
<%@page import="ict.Bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.Bean.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .LocHidden{
            display : none;
        }
        .TimeHidden{
            display : none;
        }        
    </style>

    <script type="text/javascript">
        function showHide() {
            var SP = document.getElementById("sp");
            var D = document.getElementById("d");

            var LocHidden = document.getElementsByClassName("LocHidden");
            var TimeHidden = document.getElementsByClassName("TimeHidden");

            for (var i = 0; i != LocHidden.length; i++) {
                if (SP.checked)
                    LocHidden[i].style.display = "block";
                else
                    LocHidden[i].style.display = "none";
            }

            for (var i = 0; i != TimeHidden.length; i++) {
                if (SP.checked)
                    TimeHidden[i].style.display = "block";
                else
                    TimeHidden[i].style.display = "none";
            }

            for (var i = 0; i != LocHidden.length; i++) {
                if (D.checked){
                    LocHidden[i].style.display = "none";
                    TimeHidden[i].style.display = "none";
                }
            }

        }
    </script>

    <body>
        <%
            MemberBean newcb = (MemberBean) session.getAttribute("MemberBean");
        %>
        <a href="welcome.jsp">Back</a>
        <a href="orderFoodControl?action=list&memid=<%=newcb.getMemID()%>">Back to food list</a>
        <br>
        <p>Your Point : <%=newcb.getMemPoint()%></p>
        <%
            double total = 0;
            ArrayList<OrderFoodBean> qty = (ArrayList<OrderFoodBean>) request.getAttribute("qty");
            ArrayList<FoodBean> shoppingCart = (ArrayList<FoodBean>) request.getAttribute("shoppingCart");

            out.println("<h1>Shopping Cart</h1>");
            out.println("*Self-pick 10% off");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>ID</th> <th> Name</th><th> Description</th><th> Category</th ><th> Price</th ><th> Qty</th ><th> Action</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record
            if (shoppingCart != null & qty!=null) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    FoodBean sc = shoppingCart.get(i);
                    OrderFoodBean of = qty.get(i);
                    
                    out.println("<tr>");
                    out.println("<td>" + sc.getFoodID() + "</td>");
                    out.println("<td>" + sc.getFoodName() + "</td>");
                    out.println("<td>" + sc.getFoodDesc() + "</td>");
                    out.println("<td>" + sc.getFoodCate() + "</td>");
                    out.println("<td>" + sc.getFoodPrice() + "</td>");

                    out.println("<td>" + of.getQuantity() + "</td>");
                    out.println("<td><a href=\"orderFoodControl?action=delete&id=" + sc.getFoodID() + "\">Remove</a></td>");

                    total += sc.getFoodPrice() * of.getQuantity();

                    out.println("</tr>");
                }
            }

            out.println("</table>");
        %>

        <form action="orderFoodControl?action=pay&total=<%=total%>&memid=<%=newcb.getMemID()%>" method="POST">
            <table border='1' >
                <tr>
                    <td>Total : $<%=total%>
                    <td>Type :<br>
                        Delivery <input type="radio" name="option" value="Delivery" id="d" onclick="showHide()"><br>
                        Self-Pick <input type="radio" name="option" value="Self-Pick" id="sp" onclick="showHide()"><br>      
                    </td>
                    <td  class="LocHidden">Location :
                        <select name="location">
                            <option value="">--SELECT--</option>
                            <option value="1000">Morrison Hill</option>
                            <option value="1001">Tsing Yi</option>
                            <option value="1002">Tseung Kwan O</option>
                        </select>
                    </td>
                    <td class="TimeHidden" >
                        Date :
                        <input type="date" name="date"><br>
                        Time : 
                        <input type="time" name="time"><br>
                    </td>
                    <td>Total Price:</td>
                </tr>
            </table>
            <input type="submit" value="Payment">
        </form>

    </body>
</html>
