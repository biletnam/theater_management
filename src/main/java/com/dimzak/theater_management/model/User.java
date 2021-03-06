package com.dimzak.theater_management.model;

import com.dimzak.theater_management.util.Role;

/**
 * @author Dimitris Zakas
 */
public class User {

    private int id;

    private String username;

    private String password;

    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean hasRole(Role role) {
        return role.equals(this.role);
    }

    @Override
    public String toString() {
        return username;
    }

    public boolean isValid() {
        return username != null && role != null;
    }
}
