/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 */
public class ReqResFilter implements Filter {

    private static final Logger logger = Logger.getLogger(ReqResFilter.class);
    private FilterConfig filterConfig = null;
    private ArrayList<String> urlList;

    @Override
    public void destroy() {
        logger.debug("ReqResFilter - destroy() called.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        logger.debug("ReqResFilter - doFilter() called.");
        long start = System.currentTimeMillis();
        String address = request.getRemoteAddr();
        String file = ((HttpServletRequest) request).getRequestURI();
        HttpServletRequest req = (HttpServletRequest) request;
        // HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getServletPath();
        boolean allowedRequest = false;
        if (urlList.contains(url)) {
            allowedRequest = true;
        }
        if (allowedRequest) {
            request.getRequestDispatcher("logIn.html?act=loginClick").forward(
                    request, response);
            return;
        }
        chain.doFilter(request, response);
        logger.debug("User access! " + " $$ User IP: " + address
                + " $$ User Port: " + request.getRemotePort()
                + " $$ Resource: " + file + " $$ Milliseconds used: "
                + (System.currentTimeMillis() - start));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("ReqResFilter - init() called.");
        this.filterConfig = filterConfig;
        // Get init parameter
        String urls = filterConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        urlList = new ArrayList<String>();
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }
    }
}
