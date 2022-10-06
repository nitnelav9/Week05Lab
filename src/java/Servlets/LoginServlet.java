/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.User;
import Services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author valentinmorales
 */
public class LoginServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
   
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        if(user==null)
        {
            user = new User();
        }
        
        
        if (user.getName()==null || user.getName().equals(""))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           
     
        } 
        else if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }
        else 
        {
            // Already created.            
            response.sendRedirect("home");
        }
            
        
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
       
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        
        request.setAttribute("name", name);
        request.setAttribute("password", password);
        
        if (name == null || name.equals("") || password == null || password.equals("")) {
            
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
        }
        
        
        AccountService login = new AccountService();
        User user = login.login(name, password);
        
        
        
        if(user!=null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
         
            response.sendRedirect("home");
        }
        else
        {
            request.setAttribute("message", "Invalid entry. Username or Passworwd not correct.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        
     
    }


}
