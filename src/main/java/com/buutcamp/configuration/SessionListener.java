package com.buutcamp.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session created!");
        httpSessionEvent.getSession().setMaxInactiveInterval(300);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session terminated!");

    }
}
