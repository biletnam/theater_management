package com.dimzak.theater_management.controller;

import com.dimzak.theater_management.model.User;
import com.dimzak.theater_management.service.UserService;
import com.dimzak.theater_management.util.DataAccess;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@RequestScoped
@Named
public class UserController {

    @Inject
    @DataAccess
    private UserService userService;

    @Inject
    private transient Logger logger;

    private List<User> users;

    private User selectedUser;

    private User newUser = new User();

    private String selectedUsername;

    public void doCreateUser() {
        logger.info("Creating user " + newUser.getUsername()) ;
        userService.createUser(newUser);
    }

    public void doUpdateUser(){
        logger.info("Updating user " + selectedUser.getUsername()) ;
        userService.updateUser(selectedUser);
    }

    public void doDeleteUsers(){
        logger.info("Deleting user " + selectedUser.getUsername() + " " + selectedUser.getId());
        List<User> toBeDeleted = new ArrayList<>();
        toBeDeleted.add(selectedUser);
        userService.deleteUsers(toBeDeleted);
    }

    public void loadUser() {
        logger.info("Loading User: " + selectedUsername);
        selectedUser = userService.getUserByUsername(selectedUsername);
    }


    public List<User> getUsers() {
        return users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public String getSelectedUsername() {
        return selectedUsername;
    }

    public void setSelectedUsername(String selectedUsername) {
        this.selectedUsername = selectedUsername;
    }

    @PostConstruct
    public void init() {
        users = this.userService.getAllUsers();
        selectedUser = users.get(0);
    }
}
