/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util.filter;

import com.bul.zydex.model.UserMaster;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 */
public class SessionFilter implements Filter {

    private static final Logger logger = Logger.getLogger(SessionFilter.class);

    @Override
    public void destroy() {
        logger.debug("SessionFilter destroy() called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        logger.debug("SessionFilter doFilter() called");

        HttpServletRequest req = (HttpServletRequest) request;
        // HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        if (null == session) {
            request.getRequestDispatcher("out.html?act=redirectToSessionExp")
                    .forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("SessionFilter init() called");
    }
}
