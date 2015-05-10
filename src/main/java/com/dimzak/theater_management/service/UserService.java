package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Dimitris Zakas
 */
public interface UserService {

    public User getUserByUsername(String username);

    public User getUserByUserPass(String username, String password);

    public List<User> getAllUsers();

    public boolean deleteUsers(List<User> user);

    public boolean updateUser(User user);

    public boolean createUser(User user);
}
