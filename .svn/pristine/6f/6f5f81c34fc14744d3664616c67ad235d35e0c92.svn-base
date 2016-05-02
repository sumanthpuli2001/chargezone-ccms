/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 */
public class MyServletContextListener implements ServletContextListener,
        ServletContextAttributeListener {

    private static final Logger logger = Logger
            .getLogger(MyServletContextListener.class);

    @Override
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        logger.debug("MyServletContextListener attributeAdded() called");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        logger.debug("MyServletContextListener attributeRemoved() called");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        logger.debug("MyServletContextListener attributeReplaced() called");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        logger.debug("MyServletContextListener contextDestroyed() called");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        logger.debug("MyServletContextListener contextInitialized() called");
    }
}
