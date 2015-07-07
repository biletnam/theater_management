package com.dimzak.theater_management.service;

import com.dimzak.theater_management.util.DataAccess;
import com.dimzak.theater_management.model.User;
import com.dimzak.theater_management.util.Role;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitris Zakas
 */
@ApplicationScoped
@DataAccess
public class UserServiceImpl implements UserService {

    @Resource(lookup = "java:jboss/datasources/theater_managementDS")
    private DataSource dataSource;

    @Override
    public User getUserByUsername(String username) {

        User user = new User();
        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from users where username = " + "\"" + username + "\"" + ";";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setUsername(username);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public User getUserByUserPass(String username, String password) {
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from users where username = " + "\"" + username + "\"" + " and password = " + "\"" + password + "\"" + ";";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));
                user.setUsername(username);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {

            String sql = "select * from users ;";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("user_id"));
                user.setRole(Role.valueOf(rs.getString("role")));
                userList.add(user);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return userList;
    }

    @Override
    public boolean deleteUsers(List<User> users) {
        Boolean result = false;

        try (Connection connection = dataSource.getConnection()) {
            for (User user: users) {
                String sql = "delete from users where username = \"" + user.getUsername() + "\";";
                System.out.println(sql);
                connection.createStatement().executeUpdate(sql);

            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        Boolean result = false;

        try (Connection connection = dataSource.getConnection()) {
            String sql = "update users set user_id = " + user.getId() +
                    ", username = " + "\"" + user.getUsername() + "\"" +
                    ", password = " + "\"" + user.getPassword() + "\"" +
                    ", role = " + "\"" + user.getRole() + "\"" +
                    " where user_id = " + user.getId() + ";";
            System.out.println(sql);
            connection.createStatement().executeUpdate(sql);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean createUser(User user) {
        Boolean result = false;

        try (Connection connection = dataSource.getConnection()) {
            String sql = "insert into users values (null, \"" + user.getUsername() + "\", \"" + user.getPassword() + "\", \"" + user.getRole() + "\");";
            System.out.println(sql);
            connection.createStatement().executeUpdate(sql);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




}
