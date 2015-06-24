package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.User;
import com.dimzak.theater_management.util.DataAccess;
import com.dimzak.theater_management.util.Role;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@ApplicationScoped
@DataAccess
public class LoginServiceImpl implements LoginService,Serializable  {

    @Resource(lookup = "java:jboss/datasources/theater_managementDS")
    private DataSource dataSource;

    @Inject
    private transient Logger logger;

    @Override
    public User validateUser(String username, String password) {
        PreparedStatement ps = null;
        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            logger.info("validateUser " + username);
            ps = connection.prepareStatement("Select * from users where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Found role");
                //result found, means valid inputs
                user.setId(rs.getInt("user_id"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());

        }
        return user;
    }
}
