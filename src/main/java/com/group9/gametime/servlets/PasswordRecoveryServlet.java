package com.group9.gametime.servlets;

import com.group9.gametime.beans.EmailMessage;
import com.group9.gametime.beans.User;
import com.group9.gametime.dao.JDBC;
import com.group9.gametime.servlets.helpers.EmailUtility;
import com.group9.gametime.servlets.helpers.RandomPasswordGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PasswordRecoveryServlet
 */
@WebServlet("/PasswordRecoveryServlet")
public class PasswordRecoveryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JDBC recoveryJDBC;

        RandomPasswordGenerator randomPWGenerator = RandomPasswordGenerator.getInstance();
        String randomPassword = randomPWGenerator.getRandomPassword();
        
        try {
            recoveryJDBC = JDBC.getInstance();
            String email = request.getParameter("email");
            EmailMessage emailMessage = new EmailMessage();
            emailMessage.setTo(email);
            emailMessage.setSubject("Game-Time Password Recovery");
            User user = recoveryJDBC.getUserFromEmail(email);

            //set user password to randomly generated password
            user.setPassword(randomPassword);
            
            emailMessage.setMessage("Hello " + user.getUsername() + "\n\n Your new password is: " + user.getPassword());

            try {
                EmailUtility.sendMail(emailMessage);
            } catch (Exception e){
                System.out.println("----------------Email not sent---------------");
                e.printStackTrace();
            }

            response.sendRedirect("login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp");
        }

    }
}
