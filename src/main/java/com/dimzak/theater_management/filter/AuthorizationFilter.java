package com.dimzak.theater_management.filter;

import com.dimzak.theater_management.model.User;

import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    @Inject
    private transient Logger logger;

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest reqt = null;
        HttpServletResponse resp = null;

        try {
            reqt = (HttpServletRequest) request;

            resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);
            String reqURI = reqt.getRequestURI();

            if (ses != null && ses.getAttribute("user") != null) {
                User user = (User) ses.getAttribute("user");
                if (reqURI.contains(user.getRole().toString())) {
                    chain.doFilter(request, response);
                    return;
                }
            }


            if (reqURI.contains("/index.xhtml")
                    || reqURI.contains("/public/")
                    || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else {
                logger.warning( "You shouldn't be here, redirecting...");
                resp.sendRedirect(reqt.getContextPath() + "/index.xhtml");
            }
        } catch (Exception e) {
            if(resp !=null && reqt !=null ) {
                logger.warning(e.getMessage());
                resp.sendRedirect(reqt.getContextPath() + "/index.xhtml");
            }
            logger.severe(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
