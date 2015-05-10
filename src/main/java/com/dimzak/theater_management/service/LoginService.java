package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.User;

/**
 * @author Dimitris Zakas
 */
public interface LoginService {

    public User validateUser(String username, String password);
}
