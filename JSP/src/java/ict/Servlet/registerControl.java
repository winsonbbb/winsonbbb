/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ict.Bean.MemberBean;
import ict.db.MHDB;

/**
 *
 * @author chiwingkwok
 */
@WebServlet(name = "registerControl", urlPatterns = {"/registerControl"})
public class registerControl extends HttpServlet {

    private MHDB db;

    public void init() {
         String url = "jdbc:derby://localhost:1527/MoreHill_DB";
        String username = "APP";
        String password = "APP";
        db = new MHDB(url, username, password);
    }

    //private CustomerDB db;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        String memId = request.getParameter("memId");
        String memPwd = request.getParameter("memPwd");
        String REmemPwd = request.getParameter("REmemPwd");
        String memName = request.getParameter("memName");
        String memAddress = request.getParameter("memAddress");
        String memPhone = request.getParameter("memPhone");
       //Integer.parseInt(memPhone);  
       //String mem_id, String mem_pw, String mem_name, String mem_address , String mem_phone
       /*if (checkName(memName)) {
            if (checkAddress(memAddress)) {
           
                    if (checkPwd(memPwd, REmemPwd)) {
                        if ("register".equalsIgnoreCase(action)) {
                            //while loop use to generate not repeat id
                            if(db.register(memId, memPwd, memName, memAddress,Integer.parseInt(memPhone)))
                                System.out.println("Registeration Successfully!");
                            else
                                System.out.println("Database Error!");
                        
                    }
                }
            }
        }*/
        db.register(memId, memPwd, memName, memAddress,Integer.parseInt(memPhone));
    }
    

    public boolean checkPwd(String pwd, String Rpwd) {
        if (pwd.length() > 0 && Rpwd.length() > 0) {
            if (pwd.equals(Rpwd)) {
                return true;
            } else {
                System.out.println("Confirm Password and Password not mathch! Please try  again !");
                return false;
            }
        } else {
            System.out.println("Please enter the Password !");
            return false;
        }
    }

    public boolean checkName(String name) {
        if (name.length() > 0) {
            return true;
        } else {
            System.out.println("Please enter your name !");
            return false;
        }
    }

  
    
    public boolean checkAddress(String address) {
        if (address.length() > 0) {
            return true;
        } else {
            System.out.println("Please enter your Address !");
            return false;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

