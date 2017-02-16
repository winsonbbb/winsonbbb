/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.Servlet;

import ict.Bean.MemberBean;
import ict.db.MHDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author chiwingkwok
 */
@WebServlet(name = "HandleOrder", urlPatterns = {"/handleorder"})
public class handleOrder extends HttpServlet{
     private MHDB db;
     private MemberBean mb;
     
        public void init() {
        String url = "jdbc:derby://localhost:1527/MoreHill_DB";
        String username = "APP";
        String password = "APP";
        db = new MHDB(url, username, password);
        }
        
         protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer 
            String id = request.getParameter("element_1");
            mb = db.queryCustByID(id);
            HttpSession sessoin =  request.getSession(true);
            sessoin.setAttribute("MemberBean", mb);
// set the result into the attribute 
            //mb.getMem_point();
            //request.setAttribute("nfoods", foods);
// redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/buysuccess.jsp");
            rd.forward(request, response);
        }
    }
}