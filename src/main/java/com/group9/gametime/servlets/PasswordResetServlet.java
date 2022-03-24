package com.group9.gametime.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group9.gametime.beans.User;
import com.group9.gametime.dao.JDBC;

@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("password_reset.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("username");
    	String newPassword = request.getParameter("password");

    	try {
        	JDBC passwordResetJDBC = JDBC.getInstance();
            User user = passwordResetJDBC.getUserFromUsername(username);

            user.setPassword(newPassword);
            long userID = user.getId();
            passwordResetJDBC.updatePassword(userID, newPassword);
   
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	response.sendRedirect("homepage.jsp");
    }
}
