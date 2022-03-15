package com.group9.gametime.builders;
import com.group9.gametime.beans.User;

public class UserBuilder {
    private String email;
    private String password;
    private String username;
    
    public UserBuilder() {}
    
    public UserBuilder setEmail(String email) {
    	this.email = email;
    	return this;
    }
    
    public UserBuilder setPassword(String password) {
    	this.password = password;
    	return this;
    }
    
    public UserBuilder setUsername(String username) {
    	this.username = username;
    	return this;
    }
    
    public User createUser() {
    	return new User(email, password, username);
    }
}
