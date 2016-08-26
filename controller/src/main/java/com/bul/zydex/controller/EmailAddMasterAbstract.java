/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.service.EmailAddMasterService;


/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterAbstract extends CustomAbstract {

    protected EmailAddMasterService<EmailAddMaster> emailAddMasterService;

    public EmailAddMasterService<EmailAddMaster> getEmailAddMasterService() {
        return emailAddMasterService;
    }

    public void setEmailAddMasterService(EmailAddMasterService<EmailAddMaster> emailAddMasterService) {
        this.emailAddMasterService = emailAddMasterService;
    }
    

}
