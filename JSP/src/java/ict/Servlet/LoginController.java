/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import ict.Bean.MemberBean;
import ict.db.MHDB;

/**
 *
 * @author chiwingkwok
 */
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController extends HttpServlet {

    private MHDB db;
    private PrintWriter out;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (!isAuthenticated(request) && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }

    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("element_1");
        String password = request.getParameter("element_2");
        
        String targetURL;
        boolean isValid = db.isValidUser(username, password);
         boolean isManager = db.isManager(username, password);
        if (isValid) {
            HttpSession session = request.getSession(true);
            MemberBean bean = new MemberBean();
            bean.setMem_id(username);
            bean.setMem_pw(password);
            session.setAttribute("MemberBean", bean);
            targetURL = "/welcome.jsp";
        }
   
        else {
            targetURL = "/loginError.jsp";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("MemberBean") != null) {
            result = true;
        }
        return result;
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetURL = "index.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("MemberBean");
            session.invalidate();
        }
    }

    public void init() {
         String url = "jdbc:derby://localhost:1527/MoreHill_DB";
        String username = "APP";
        String password = "APP";
        db = new MHDB(url, username, password);
    }
}
