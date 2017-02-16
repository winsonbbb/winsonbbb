<%-- 
    Document   : welcome
    Created on : Nov 6, 2014, 3:50:37 PM
    Author     : Tak
--%>
<%@page import="ict.Bean.Foodbean"%>
<%@page import="ict.Bean.Orderbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.Bean.MemberBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <% MemberBean newcb = (MemberBean) session.getAttribute("MemberBean");%>
        <a href="welcome.jsp">Back</a>
        <br>
        <p>Your Point : <%=newcb.getMem_point()%></p>
        <%
            double total = 0;
 
            ArrayList<Foodbean> shoppingCart = (ArrayList<Foodbean>) request.getAttribute("shoppingCart");

            out.println("<h1>Shopping Cart</h1>");
            out.println("*Self-pick 10% off");
            out.println("<table border='1' >");
            out.println("<tr>");
            out.println("<th>ID</th> <th> Name</th><th> Description</th><th> Category</th ><th> Price</th ><th> Qty</th ><th> Action</th >");
            out.println("</tr>");
            // loop through the customer array to display each customer record
            if (shoppingCart != null ) {
                for (int i = 0; i < shoppingCart.size(); i++) {
                    Foodbean lf = shoppingCart.get(i);
                    

                    out.println("<tr>");
                    out.println("<td>" + lf.getFoodID() + "</td>");
                    out.println("<td>" + lf.getFoodName() + "</td>");
                    out.println("<td>" + lf.getFoodDesc() + "</td>");
                    out.println("<td>" + lf.getFoodCate() + "</td>");
                    out.println("<td>" + lf.getFoodPrice() + "</td>");
                    
                    total += lf.getFoodPrice() ;

                    out.println("</tr>");
                }
            }

            out.println("</table>");
        %>

        <form action="orderFoodControl?action=pay&total=<%=total%>&memid=<%=newcb.getMem_id()%>" method="POST">
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

                </tr>
            </table>
            <input type="submit" value="Payment">
        </form>

    </body>

</body>
</html>
