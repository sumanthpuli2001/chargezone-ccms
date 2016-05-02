/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 */
public class MyServletRequestListener implements ServletRequestListener,
        ServletRequestAttributeListener {

    private static final Logger logger = Logger
            .getLogger(MyServletRequestListener.class);

    @Override
    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        logger.debug("MyServletRequestListener attributeAdded() called");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        logger.debug("MyServletRequestListener attributeRemoved() called");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        logger.debug("MyServletRequestListener attributeReplaced() called");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        logger.debug("MyServletRequestListener requestDestroyed() called");
    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        logger.debug("MyServletRequestListener requestInitialized() called");
    }
}
