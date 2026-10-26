/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class EmailTemplate {
    
    private int id;
    private String title;
    private String subject;
    private String bodytext;
    
    public EmailTemplate() {
    }
    
    public EmailTemplate(int id, String title, String subject, String bodytext) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.bodytext = bodytext;
        
    }

    public int getId() {
        return id;
    }

    public EmailTemplate setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EmailTemplate setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailTemplate setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBodytext() {
        return bodytext;
    }

    public EmailTemplate setBodytext(String bodytext) {
        this.bodytext = bodytext;
        return this;
    }
    
    
}
