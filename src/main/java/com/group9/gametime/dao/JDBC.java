package com.group9.gametime.dao;

import com.group9.gametime.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private Connection con;

    public JDBC() throws Exception {
        this.con = createConnection();
    }

    public Connection createConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/game-time";
        String uname = "root";    // to be replaced according to DB configuration
        String upass = "root";    // to be replaced according to DB configuration

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, uname, upass);
    }

    public void insertUser(User user) throws SQLException {
        String query = "";
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        //format statement so values are enclosed in quotation marks
        query = "INSERT INTO user (email, username, password, is_verified) VALUES "
                + "(" + "\"" + email + "\"" +"," + "\"" + username + "\"" + "," + "\"" + password + "\"" + ", 0)";
        Statement st = con.createStatement();

        st.executeUpdate(query);
        st.close();
    }

    public List<User> getUsers() throws SQLException {
        String query = "SELECT * FROM user";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<User> users = new ArrayList();

        while (rs.next()) {
            String email = rs.getString("email");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");

            User user = new User(email, username1, password1);
            users.add(user);
        }
        rs.close();

        return users;
    }

    public User getUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE username=" + "\"" + username + "\" AND password ="+ "\"" + password + "\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        User user = null;

        if (rs.next()) {
            String email = rs.getString("email");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");

            user = new User(email, username1, password1);
        }
        rs.close();

        return user;
    }

    public User getUserFromEmail(String email) throws SQLException {
        String query = "SELECT * FROM user WHERE email =" + "\"" + email + "\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        User user = null;

        if (rs.next()) {
            Long id = rs.getLong("userID");
            String email1 = rs.getString("email");
            String username = rs.getString("username");
            String password = rs.getString("password");

            user = new User(email1, username, password);
            user.setId(id);
        }
        rs.close();

        return user;
    }

    public void updateIsVerified(int id) throws SQLException {
        String query = "UPDATE user SET is_verified=1 WHERE userID=" + id;
        Statement st = con.createStatement();

        st.executeUpdate(query);
        st.close();
    }
}
