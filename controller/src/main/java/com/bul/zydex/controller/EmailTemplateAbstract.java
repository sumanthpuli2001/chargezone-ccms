/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.service.EmailTemplateService;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailTemplateAbstract extends CustomAbstract {

    protected EmailTemplateService<EmailTemplate> emailTemplateService;
    protected Validator emailTemplateValidator;

    public EmailTemplateService<EmailTemplate> getEmailTemplateService() {
        return emailTemplateService;
    }

    public void setEmailTemplateService(EmailTemplateService<EmailTemplate> emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    public Validator getEmailTemplateValidator() {
        return emailTemplateValidator;
    }

    public void setEmailTemplateValidator(Validator emailTemplateValidator) {
        this.emailTemplateValidator = emailTemplateValidator;
    }

}
