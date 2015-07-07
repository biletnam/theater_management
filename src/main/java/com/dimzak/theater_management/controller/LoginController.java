package com.dimzak.theater_management.controller;

import com.dimzak.theater_management.model.User;
import com.dimzak.theater_management.service.LoginService;
import com.dimzak.theater_management.service.LoginServiceImpl;
import com.dimzak.theater_management.util.DataAccess;
import com.dimzak.theater_management.util.Resources;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@SessionScoped
@Named
public class LoginController implements Serializable {

    private String username;

    private String password;

    @Inject @DataAccess
    private LoginService loginService;

    @Inject
    private transient Logger logger;

    public String login() throws Exception {
        logger.info("Logging in...");
        User user = loginService.validateUser(username, password);
        logger.info("Validation returned: " + user.getUsername());

        if (user.isValid()) {
            HttpSession session = Resources.getSession();
            session.setAttribute("user", user);

            // Role found
            return user.getRole().toString() + "?faces-redirect=true";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
        }
        return "index?faces-redirect=true";


    }

    //logout event, invalidate session
    public String logout() {
        logger.info("Logging out");
        HttpSession session = Resources.getSession();
        session.invalidate();
        return "index?faces-redirect=true";
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

}
