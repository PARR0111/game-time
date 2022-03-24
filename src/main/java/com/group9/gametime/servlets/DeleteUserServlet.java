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

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
    	String username = (String) session.getAttribute("username");

    	try {
        	JDBC deleteUserJDBC = JDBC.getInstance();
            
        	User user = deleteUserJDBC.getUserFromUsername(username);
        	long userID = user.getId();
        	
        	deleteUserJDBC.deleteUser(userID);
   
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	response.sendRedirect("login.jsp");
	}

}

