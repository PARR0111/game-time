package com.group9.gametime.servlets;

import com.group9.gametime.beans.EmailMessage;

import com.group9.gametime.beans.User;
import com.group9.gametime.dao.JDBC;
import com.group9.gametime.servlets.helpers.EmailUtility;
import com.group9.gametime.builders.UserBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	UserBuilder userBuilder = new UserBuilder();
    	
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        User user = userBuilder.setEmail(email).setPassword(password).setUsername(username).createUser();

        try {
            boolean valid_user = true;
        	
        	JDBC registerJDBC =JDBC.getInstance();
            
            //establish ArrayList of currently registered users
            ArrayList<User> registeredUsers = (ArrayList<User>) registerJDBC.getUsers();
            
            for ( User registeredUser : registeredUsers ) {
            	if ( registeredUser.getEmail().equals(user.getEmail()) || registeredUser.getUsername().equals(user.getUsername()) ) {
            		System.out.println("-----------------------Invalid User-------------------");
            		valid_user = false;
            	}
            	
            }
            
            if ( valid_user ) {
	            registerJDBC.insertUser(user);
	
	            //get id from newly inserted row in database
	            User userFromEmail = registerJDBC.getUserFromEmail(email);
	            EmailMessage emailMessage = new EmailMessage();
	            emailMessage.setSubject("Game-Time Account Verification");
	            emailMessage.setTo(email);
	
	            emailMessage.setMessage("Hello " + username + ", click the link below to verify your account:\n\n"
	                    + "http://localhost:8080" + request.getContextPath() + "/account_verification?id=" + userFromEmail.getId());
	
	            try {
	                EmailUtility.sendMail(emailMessage);
	            } catch (Exception e){
	                System.out.println("----------------Email not sent---------------");
	                e.printStackTrace();
	            }
	
	            response.sendRedirect("login.jsp");
            }
            else {
            	response.sendRedirect("verification_failed.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
