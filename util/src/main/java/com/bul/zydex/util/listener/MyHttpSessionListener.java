/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 *
 * @author jayesh
 */
public class MyHttpSessionListener implements HttpSessionListener,
        HttpSessionActivationListener, HttpSessionBindingListener,
        HttpSessionAttributeListener {

    private static final Logger logger = Logger
            .getLogger(MyHttpSessionListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        logger.debug("MyHttpSessionListener attributeAdded() called");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        logger.debug("MyHttpSessionListener attributeRemoved() called");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        logger.debug("MyHttpSessionListener attributeReplaced() called");
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        logger.debug("MyHttpSessionListener sessionCreated() called");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        logger.debug("MyHttpSessionListener sessionDestroyed() called");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent arg0) {
        logger.debug("MyHttpSessionListener sessionDidActivate() called");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent arg0) {
        logger.debug("MyHttpSessionListener sessionWillPassivate() called");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
        logger.debug("MyHttpSessionListener valueBound() called");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        logger.debug("MyHttpSessionListener valueUnbound() called");
    }
}
