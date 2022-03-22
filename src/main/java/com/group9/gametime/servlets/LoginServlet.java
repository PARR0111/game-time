package com.group9.gametime.servlets;

import com.group9.gametime.beans.User;
import com.group9.gametime.dao.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
        	JDBC loginJDBC = JDBC.getInstance();
            User user = loginJDBC.getUser(username, password);

            if ( user != null ) {
                System.out.println("Successful login");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("homepage.jsp");
            } else {
                System.out.println("Login failed");
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
