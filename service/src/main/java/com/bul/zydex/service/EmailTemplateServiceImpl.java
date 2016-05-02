/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.EmailTemplateDAO;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailTemplateServiceImpl<T> extends GenericsServiceImpl<T> implements EmailTemplateService<T> {

    protected EmailTemplateDAO<T> emailTemplateDAO;
    
    public EmailTemplateDAO<T> getEmailTemplateDAO() {
        return emailTemplateDAO;
    }
    
    public void setEmailTemplateDAO(EmailTemplateDAO<T> emailTemplateDAO) {
        this.emailTemplateDAO = emailTemplateDAO;
        setGenericsDAO(emailTemplateDAO);
    }
    
}
