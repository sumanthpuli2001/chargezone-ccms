/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service;

import com.bul.zydex.dao.EmailMetaTagDAO;

/**
 *
 * @author Aman
 */
public class EmailMetaTagServiceImpl <T>extends GenericsServiceImpl<T> implements EmailMetaTagService<T>{ 
    protected EmailMetaTagDAO<T> emailMetaTagDAO;

    public EmailMetaTagDAO<T> getEmailMetaTagDAO() {
        return emailMetaTagDAO;
    }

    public void setEmailMetaTagDAO(EmailMetaTagDAO<T> emailMetaTagDAO) {
        this.emailMetaTagDAO = emailMetaTagDAO;
        setGenericsDAO(emailMetaTagDAO);
    }
    
    
    
}
