package com.group9.gametime.beans;

import java.io.Serializable;

/**
 * This class represents the User model. This model class can be used thoroughout all
 * layers, the data layer, the controller layer and the view layer.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private String username;
    private int is_verified;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.is_verified = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIsVerified(int i) {
        this.is_verified = i;
    }

    public int getIsVerified() {
        return this.is_verified;
    }

    /**
     * The user ID is unique for each User. So this should compare User by ID only.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof User) && (id != null)
                ? id.equals(((User) other).id)
                : (other == this);
    }

    /**
     * The user ID is unique for each User. So User with same ID should return same hashcode.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return (id != null)
                ? (this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("User[id=%d,email=%s,username=%s]",
                id, email, username);
    }
}
