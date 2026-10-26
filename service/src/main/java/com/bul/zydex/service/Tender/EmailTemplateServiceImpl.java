/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.EmailTemplateDao;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class EmailTemplateServiceImpl<T> extends GenericsServiceImpl<T> implements EmailTemplateService<T> {
    
    private EmailTemplateDao<T> emailTemplateDao;

    public EmailTemplateDao<T> getEmailTemplateDao() {
        return emailTemplateDao;
    }

    public void setEmailTemplateDao(EmailTemplateDao<T> emailTemplateDao) {
        this.emailTemplateDao = emailTemplateDao;
        setGenericsDAO(emailTemplateDao);
    }
}
